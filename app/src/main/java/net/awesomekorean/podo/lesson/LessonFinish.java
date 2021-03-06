package net.awesomekorean.podo.lesson;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.review.model.ReviewErrorCode;
import com.google.android.play.core.review.testing.FakeReviewManager;
import com.google.android.play.core.tasks.OnCompleteListener;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;

import net.awesomekorean.podo.AdsManager;
import net.awesomekorean.podo.PlaySoundPool;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UserInformation;
import net.awesomekorean.podo.lesson.lessons.Lesson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LessonFinish extends AppCompatActivity implements View.OnClickListener {

    FirebaseAnalytics firebaseAnalytics;

    TextView tvWord;
    TextView tvSentence;
    Button btnMyWords;
    Button btnMySentences;
    ProgressBar progressBar;
    TextView tvProgress;
    Button btnComplete;
    PlaySoundPool playSoundPool;
    Context context;
    AdsManager adsManager;

    Lesson lesson;

    LessonProgress lessonProgress;
    RecyclerView recyclerView;
    ArrayList<LessonFinishItems> list;
    LessonFinishItems items;
    LessonFinishAdapter adapter;
    boolean btnMyWordsClicked;
    boolean btnMySentencesClicked;

    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_finish);

        context = getApplicationContext();
        adsManager = AdsManager.getInstance();

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        if(adsManager.interstitialAd == null || !adsManager.interstitialAd.isLoaded()) {
            adsManager.loadFullAds(context);
        }

        tvWord = findViewById(R.id.tvWord);
        tvSentence = findViewById(R.id.tvSentence);
        btnMyWords = findViewById(R.id.btnMyWords);
        btnMySentences = findViewById(R.id.btnMySentences);
        progressBar = findViewById(R.id.progressBar);
        tvProgress = findViewById(R.id.tvProgress);
        btnComplete = findViewById(R.id.btnComplete);
        recyclerView = findViewById(R.id.recyclerView);
        btnMyWords.setOnClickListener(this);
        btnMySentences.setOnClickListener(this);
        btnComplete.setOnClickListener(this);

        btnMyWordsClicked = false;
        btnMySentencesClicked = false;
        list = new ArrayList<>();
        adapter = new LessonFinishAdapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        playSoundPool = new PlaySoundPool(context);
        playSoundPool.playSoundYay();

        UserInformation userInformation = SharedPreferencesInfo.getUserInfo(context);
        List<String> lessonComplete = userInformation.getLessonComplete();

        lesson = LessonFrame.lesson;

        if (lessonComplete.contains(lesson.getLessonId())) {
            tvWord.setText("+"+0);
            tvSentence.setText("+"+0);
            System.out.println("이미완료한레슨입니다.");

        } else {
            int getWordNo = lesson.getWordFront().length;
            int getSentenceNo = lesson.getReviewId().length;
            tvWord.setText("+"+getWordNo);
            tvSentence.setText("+"+getSentenceNo);
        }

        // 레슨완료 정보 업데이트 하기
        userInformation.updateCompleteList(context, lesson.getLessonId(), false);

        lessonProgress = new LessonProgress(userInformation.getLessonComplete());

        int getTotalWordNo = lessonProgress.getTotalWordNo();
        int getTotalSentenceNo = lessonProgress.getTotalSentenceNo();
        int getMyWordNo = lessonProgress.getMyWords().size();
        int getMySentenceNo = lessonProgress.getMySentences().size();
        double calProgress = (double) (getMyWordNo + getMySentenceNo) * 100 /(getTotalWordNo + getTotalSentenceNo);
        int progress = (int) Math.round(calProgress);

        tvProgress.setText(progress + "%");

        ObjectAnimator animator = ObjectAnimator.ofInt(progressBar, "progress", 0, progress);
        animator.setDuration(1500);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();

        Animation aniScale = AnimationUtils.loadAnimation(context, R.anim.scale_1000);
        tvProgress.startAnimation(aniScale);

        Animation aniMoveDown = AnimationUtils.loadAnimation(context, R.anim.move_up_small);
        tvWord.startAnimation(aniMoveDown);
        tvSentence.startAnimation(aniMoveDown);


        // 인앱리뷰 여부 체크하기
        int completeLessonSize = userInformation.getLessonComplete().size();

        if(completeLessonSize == 5 || completeLessonSize == 10 || completeLessonSize == 15 || completeLessonSize == 20) {

            btnComplete.setEnabled(false);
            bundle = new Bundle();
            firebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());

            final ReviewManager reviewManager = ReviewManagerFactory.create(this);
            Task<ReviewInfo> request = reviewManager.requestReviewFlow();
            request.addOnCompleteListener(new OnCompleteListener<ReviewInfo>() {
                @Override
                public void onComplete(@NonNull Task<ReviewInfo> task) {

                    if(task.isSuccessful()) {
                        System.out.println("인앱리뷰요청 성공");
                        firebaseAnalytics.logEvent("inAppReview_request_succeed", bundle);

                        ReviewInfo reviewInfo = task.getResult();
                        Task<Void> flow = reviewManager.launchReviewFlow(LessonFinish.this, reviewInfo);
                        flow.addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                System.out.println("인앱리뷰 완료");
                                firebaseAnalytics.logEvent("inAppReview_succeed", bundle);

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(Exception e) {
                                System.out.println("인앱리뷰 실패" + e);
                                bundle.putString("errorMsg", e.getMessage());
                                firebaseAnalytics.logEvent("inAppReview_failed", bundle);
                            }
                        });

                    } else {
                        System.out.println("인앱리뷰요청 실패 : " + task.getException().getMessage());
                        bundle.putString("errorMsg", task.getException().getMessage());
                        firebaseAnalytics.logEvent("inAppReview_request_failed", bundle);
                    }

                    btnComplete.setEnabled(true);
                }
            });
        }
    }


    // 애드몹 광고 보여주고 종료
    private void playAds() {
        if(adsManager.interstitialAd.isLoaded()) {
            adsManager.playFullAds(this);
        }
        finish();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnMyWords :
                if(!btnMyWordsClicked) {
                    Map<String, String> myWords = lessonProgress.getMyWords();
                    setList(myWords);
                    setBtns(true, false);

                } else {
                    recyclerView.setVisibility(View.GONE);
                    setBtns(false, false);
                }
                break;


            case R.id.btnMySentences :
                if(!btnMySentencesClicked) {
                    Map<String, String> mySentences = lessonProgress.getMySentences();
                    setList(mySentences);
                    setBtns(false, true);

                } else {
                    recyclerView.setVisibility(View.GONE);
                    setBtns(false, false);
                }
                break;


            case R.id.btnComplete :
                playAds();
                break;
        }
    }


    private void setList(Map<String, String> my) {
        list.clear();
        Iterator<String> keys = my.keySet().iterator();

        while (keys.hasNext()) {
            String front = keys.next();
            items = new LessonFinishItems();
            items.setFront(front);
            items.setBack(my.get(front));
            list.add(items);
        }

        adapter.notifyDataSetChanged();
        recyclerView.setVisibility(View.VISIBLE);
    }


    private void setBtns(boolean myWords, boolean mySentences) {
        btnMyWordsClicked = myWords;
        btnMySentencesClicked = mySentences;
        if(myWords) {
            setBtnsColor(R.drawable.bg_pink_25, R.drawable.bg_pink_transparent_25);
        } else if(mySentences) {
            setBtnsColor(R.drawable.bg_pink_transparent_25, R.drawable.bg_pink_25);
        } else {
            setBtnsColor(R.drawable.bg_pink_25, R.drawable.bg_pink_25);
        }
    }


    private void setBtnsColor(int myWords, int mySentences) {
        btnMyWords.setBackground(ContextCompat.getDrawable(context, myWords));
        btnMySentences.setBackground(ContextCompat.getDrawable(context, mySentences));
    }


    @Override
    public void onBackPressed() {
        playAds();
    }
}
