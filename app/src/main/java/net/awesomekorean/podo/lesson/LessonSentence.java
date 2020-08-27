package net.awesomekorean.podo.lesson;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import net.awesomekorean.podo.DownloadAudio;
import net.awesomekorean.podo.LoadingPage;
import net.awesomekorean.podo.MediaPlayerManager;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.collection.CollectionRepository;
import net.awesomekorean.podo.lesson.lessons.Lesson;

import java.util.HashMap;
import java.util.Map;


public class LessonSentence extends Fragment implements Button.OnClickListener, View.OnTouchListener {

    FirebaseStorage storage = FirebaseStorage.getInstance();

    View view;

    ImageView btnAudio;
    Button btnCollect;

    static View viewLeft;
    static View viewRight;
    static LinearLayout lessonLayout;
    static TextView tvSentenceFront;
    static TextView tvSentenceBack;
    static TextView tvSentenceExplain;

    static String[] sentenceFront;
    static String[] sentenceBack;
    static String[] sentenceExplain;
    String[] sentenceAudio;
    static Map<Integer, byte[]> sentenceAudioByte;

    LinearLayout collectResult;

    boolean isFirstAudio = true;

    ScrollView scrollView;

    private GestureDetectorCompat gestureDetectorCompat = null;

    // fragment 간 전환을 위해 만듦
    public static LessonSentence newInstance() {
        return new LessonSentence();
    }

    MediaPlayerManager mediaPlayerManager;

    Lesson lesson;
    String folder;

    private LessonFrame activity;

    static int lessonCount;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.lesson_sentence, container, false);

        lessonCount = 0;

        viewLeft = view.findViewById(R.id.viewLeft);
        viewRight = view.findViewById(R.id.viewRight);
        lessonLayout = view.findViewById(R.id.lessonLayout);
        tvSentenceFront = view.findViewById(R.id.tvSentenceFront);
        tvSentenceBack = view.findViewById(R.id.tvSentenceBack);
        tvSentenceExplain = view.findViewById(R.id.tvSentenceExplain);
        collectResult = view.findViewById(R.id.collectResult);
        btnAudio = view.findViewById(R.id.btnAudio);
        btnCollect = view.findViewById(R.id.btnCollect);
        scrollView = view.findViewById(R.id.scrollView);
        btnAudio.setOnClickListener(this);
        btnCollect.setOnClickListener(this);

        lesson = LessonFrame.lesson;
        folder = "lesson/" + lesson.getLessonId().toLowerCase();

        SwipeListenerSentence gestureListener = new SwipeListenerSentence();
        gestureListener.setActivity(activity);
        gestureDetectorCompat = new GestureDetectorCompat(activity, gestureListener);

        scrollView.setOnTouchListener(this);

        // analytics 로그 이벤트 얻기
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        Bundle bundle = new Bundle();
        firebaseAnalytics.logEvent("lesson_sentence", bundle);

        readyForLesson();

        LessonFrame.setNavigationColor(activity, LessonFrame.navigationSentence, R.drawable.bg_blue_10);

        return view;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return false;
    }


    private void readyForLesson() {
        Intent intent = new Intent(getContext(), LoadingPage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);

        int sentenceLength = lesson.getSentenceFront().length;
        sentenceAudio = new String[sentenceLength];

        sentenceFront = lesson.getSentenceFront();

        sentenceBack = lesson.getSentenceBack();

        sentenceExplain = lesson.getSentenceExplain();

        sentenceAudioByte = new HashMap<>();
        for(int i=0; i<sentenceLength; i++) {
            final Integer audioIndexSentence = i;
            sentenceAudio[i] = lesson.getLessonId().toLowerCase() + "_sentence_" + i + ".mp3";
            StorageReference storageRef = storage.getReference().child(folder).child(sentenceAudio[i]);
            final long ONE_MEGABYTE = 1024 * 1024;
            storageRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    System.out.println("오디오를 로드했습니다.");
                    sentenceAudioByte.put(audioIndexSentence, bytes);
                    if(audioIndexSentence == 0) {
                        displaySentence();
                        isFirstAudio = false;
                    }
                }
            });
        }
    }

    public void displaySentence() {
        LoadingPage loadingPage = (LoadingPage)LoadingPage.activity;
        loadingPage.finish();

        tvSentenceFront.setText(sentenceFront[lessonCount]);
        tvSentenceBack.setText(sentenceBack[lessonCount]);
        tvSentenceExplain.setText(sentenceExplain[lessonCount]);

        mediaPlayerManager = MediaPlayerManager.getInstance();
        mediaPlayerManager.setMediaPlayerByte(false, sentenceAudioByte.get(lessonCount));
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnAudio :
                if(mediaPlayerManager != null) {
                    mediaPlayerManager.playMediaPlayer(false);
                }
                break;

            case R.id.btnCollect :
                String front = sentenceFront[lessonCount];
                String back = sentenceBack[lessonCount];
                String audio = sentenceAudio[lessonCount];
                String folder = "lesson/" + lesson.getLessonId().toLowerCase();;

                DownloadAudio downloadAudio = new DownloadAudio(activity, folder, audio);
                downloadAudio.downloadAudio();

                CollectionRepository repository = new CollectionRepository(activity);
                repository.insert(front, back, audio);

                collectResult.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        collectResult.setVisibility(View.GONE);
                    }
                }, 1000);
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof LessonFrame) {
            activity = (LessonFrame) context;
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
    }
}
