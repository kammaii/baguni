package net.awesomekorean.podo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


import net.awesomekorean.podo.lesson.IntermediateFrame;
import net.awesomekorean.podo.lesson.LessonFrame;
import net.awesomekorean.podo.lesson.LessonSpecialFrame;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson;
import net.awesomekorean.podo.lesson.lessons.Lesson;
import net.awesomekorean.podo.lesson.lessons.LessonSpecial;
import net.awesomekorean.podo.reading.Reading;
import net.awesomekorean.podo.reading.ReadingFrame;

import java.io.Serializable;

public class UnlockActivity extends AppCompatActivity implements View.OnClickListener {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    LinearLayout unlockFirst;
    LinearLayout unlockSecond;
    TextView pointHave;
    TextView pointNeed;
    Button btnYes;
    Button btnNo;
    Button btnPurchasePoints;
    Button btnWatchAds;
    ImageView btnClose;

    UserInformation userInformation;
    int userPoint; // 유저 포인트

    int price5 = 5;
    int price10 = 10;
    int price15 = 15;
    int price20 = 20;
    int unlockPrice;

    String extra;
    Intent intent;
    Context context;
    AdsManager adsManager;
    boolean isActive;
    TextView unlockMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_unlock);

        context = getApplicationContext();
        adsManager = AdsManager.getInstance();
        if(adsManager.rewardedAd == null || !adsManager.rewardedAd.isLoaded()) {
            adsManager.loadRewardAds(context);
        }

        unlockFirst = findViewById(R.id.unlockFirst);
        unlockSecond = findViewById(R.id.unlockSecond);
        pointHave = findViewById(R.id.pointHave);
        pointNeed = findViewById(R.id.pointNeed);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
        btnPurchasePoints = findViewById(R.id.btnPurchasePoints);
        btnWatchAds = findViewById(R.id.btnWatchAds);
        btnClose = findViewById(R.id.btnClose);
        unlockMessage = findViewById(R.id.unlockMessage);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
        btnPurchasePoints.setOnClickListener(this);
        btnWatchAds.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        extra = getIntent().getStringExtra(getResources().getString(R.string.EXTRA_ID));

        if(extra.equals(getResources().getString(R.string.SPECIAL_LESSON))) {
            unlockPrice = price10;
        } else if(extra.equals("L")) {
            unlockPrice = price5;
        } else if(extra.equals("IL")) {
            unlockPrice = price15;
        } else if(extra.equals("AL")) {
            unlockPrice = price20;
        } else { // 읽기
            unlockPrice = price20;
        }

        isActive = getIntent().getBooleanExtra(getResources().getString(R.string.EXTRA_ISACTIVE), true);

        if(isActive) {
            unlockMessage.setText(getResources().getText(R.string.UNLOCK));
        } else {
            unlockMessage.setText(getResources().getText(R.string.UNLOCK_INACTIVE));
            unlockPrice += unlockPrice;
        }

        pointNeed.setText(String.valueOf(unlockPrice));
    }


    // 포인트 변경 후 체크
    private void checkPoint() {
        if(userPoint >= unlockPrice) {
            unlockFirst.setVisibility(View.VISIBLE);
            unlockSecond.setVisibility(View.GONE);
            btnYes.performClick();

        } else {
            unlockFirst.setVisibility(View.GONE);
            unlockSecond.setVisibility(View.VISIBLE);
            pointHave.setText(String.valueOf(userPoint));
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

        if(userInformation != null) {
            userInformation = SharedPreferencesInfo.getUserInfo(context);
            userPoint = userInformation.getPoints();
            pointHave.setText(String.valueOf(userPoint));
            checkPoint();

        // 처음 실행했을 때
        } else {
            userInformation = SharedPreferencesInfo.getUserInfo(context);
            userPoint = userInformation.getPoints();
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnYes :

                if(userPoint >= unlockPrice) {
                    unlockFirst.setVisibility(View.GONE);

                    // 포인트 차감하고 DB에 레슨아이디 추가, 해당 레슨에 unlock = true 세팅
                    int newPoint = userPoint - unlockPrice;
                    userInformation.setPoints(newPoint);

                    // 스페셜레슨 구매
                    if(extra.equals(getResources().getString(R.string.SPECIAL_LESSON))) {
                        String lessonId = getIntent().getStringExtra(getResources().getString(R.string.LESSON_ID));
                        LessonSpecial lesson = (LessonSpecial) getIntent().getSerializableExtra(getResources().getString(R.string.LESSON));
                        intent = new Intent(context, LessonSpecialFrame.class);
                        intent.putExtra(getResources().getString(R.string.LESSON), (Serializable) lesson);
                        userInformation.addSpecialLessonUnlock(lessonId);
                        startActivity(intent);


                    // 레슨 구매
                    } else if(extra.equals("L")) {
                        Lesson lesson = (Lesson) getIntent().getSerializableExtra(getResources().getString(R.string.LESSON));
                        userInformation.addLessonUnlock(lesson.getLessonId());
                        intent = new Intent(context, LessonFrame.class);
                        intent.putExtra(getResources().getString(R.string.LESSON), (Serializable) lesson);
                        startActivity(intent);

                    } else if(extra.equals("IL")) {
                        I_Lesson lesson = (I_Lesson) getIntent().getSerializableExtra(getResources().getString(R.string.LESSON));
                        userInformation.addLessonUnlock(lesson.getLessonId());
                        intent = new Intent(context, IntermediateFrame.class);
                        intent.putExtra(getResources().getString(R.string.LESSON), (Serializable) lesson);
                        startActivity(intent);


                    // 읽기 구매
                    } else {
                        Reading reading = (Reading) getIntent().getSerializableExtra(getResources().getString(R.string.READING));
                        userInformation.addReadingUnlock(reading.getReadingId());
                        intent = new Intent(context, ReadingFrame.class);
                        intent.putExtra(getResources().getString(R.string.READING), (Serializable) reading);
                        startActivity(intent);
                    }

                    SharedPreferencesInfo.setUserInfo(context, userInformation);

                    DocumentReference informationRef = db.collection(getString(R.string.DB_USERS)).document(MainActivity.userEmail);
                    informationRef.set(userInformation).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            System.out.println("레슨/읽기를 포인트로 구매했습니다.");
                            Toast.makeText(context, getString(R.string.UNLOCK_SUCCEEDED), Toast.LENGTH_LONG).show();

                            // analytics 로그 이벤트 얻기
                            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
                            Bundle bundle = new Bundle();
                            bundle.putString("type", extra);
                            bundle.putInt("points", unlockPrice);
                            firebaseAnalytics.logEvent("point_use", bundle);
                            finish();

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(context, getString(R.string.UNLOCK_FAILED), Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    unlockFirst.setVisibility(View.GONE);
                    unlockSecond.setVisibility(View.VISIBLE);
                    pointHave.setText(String.valueOf(userPoint));
                }
                break;

            case R.id.btnPurchasePoints :
                intent = new Intent(context, TopUp.class);
                startActivity(intent);
                break;


            case R.id.btnWatchAds :
                adsManager.playRewardAds(this);
                break;

            default: // btnNo, btnClose
                finish();
                break;
        }
    }
}
