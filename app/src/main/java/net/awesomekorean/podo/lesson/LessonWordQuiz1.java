package net.awesomekorean.podo.lesson;

import android.content.Context;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.analytics.FirebaseAnalytics;

import net.awesomekorean.podo.MediaPlayerManager;
import net.awesomekorean.podo.PlaySoundPool;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.lesson.lessons.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonWordQuiz1 extends Fragment implements Button.OnClickListener {

    View view;

    TextView answer;
    ImageView btn1;
    ImageView btn2;
    ImageView btn3;
    ImageView btn4;
    TextView btnText1;
    TextView btnText2;
    TextView btnText3;
    TextView btnText4;
    ImageView btnAudio;
    Switch engSwitch;


    int[] wordImage;
    int[] answerArray = new int[4]; // 현재 퀴즈 array


    int quizQuantity; // 문제 개수
    int quizNoNow = 0;
    Boolean solveWrongQuizAgain = false;
    List<Integer> wrongQuizList; // 틀린 문제 번호를 이 list 에 추가

    MediaPlayerManager mediaPlayerManager;

    PlaySoundPool playSoundPool;

    ConstraintLayout totalPage;

    Lesson lesson;

    public static LessonWordQuiz1 newInstance() {
        return new LessonWordQuiz1();
    }

    private LessonFrame activity;

    boolean engHint;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.lesson_word_quiz1, container, false);

        lesson = LessonFrame.lesson;

        wordImage = activity.wordImage;

        quizQuantity = lesson.getWordBack().length;
        wrongQuizList = new ArrayList<>();

        mediaPlayerManager = MediaPlayerManager.getInstance();

        totalPage = view.findViewById(R.id.totalPage);
        answer = view.findViewById(R.id.answer);
        btn1 = view.findViewById(R.id.btn1);
        btn2 = view.findViewById(R.id.btn2);
        btn3 = view.findViewById(R.id.btn3);
        btn4 = view.findViewById(R.id.btn4);
        btnText1 = view.findViewById(R.id.btnText1);
        btnText2 = view.findViewById(R.id.btnText2);
        btnText3 = view.findViewById(R.id.btnText3);
        btnText4 = view.findViewById(R.id.btnText4);
        btnAudio = view.findViewById(R.id.btnAudio);
        engSwitch = view.findViewById(R.id.engSwitch);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btnAudio.setOnClickListener(this);
        totalPage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        engHint = SharedPreferencesInfo.getEngHint(getContext());
        setEngHint(engHint);
        engSwitch.setChecked(engHint);

        engSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    setEngHint(true);
                    SharedPreferencesInfo.setEngHint(getContext(), true);
                } else {
                    setEngHint(false);
                    SharedPreferencesInfo.setEngHint(getContext(), false);
                }
                engHint = SharedPreferencesInfo.getEngHint(getContext());
            }
        });

        // analytics 로그 이벤트 얻기
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        Bundle bundle = new Bundle();
        firebaseAnalytics.logEvent("lesson_quiz1", bundle);

        makeQuiz(quizNoNow);

        // 정답, 오답 오디오 미리 로드해놓기
        playSoundPool = new PlaySoundPool(activity);

        LessonFrame.setNavigationColor(activity, LessonFrame.navigationQuiz, R.drawable.bg_green_10);

        return view;
    }


    // 영어 표기 세팅
    private void setEngHint(boolean engHint) {
        int visible;

        if(engHint) {
            visible = View.VISIBLE;
        } else {
            visible = View.INVISIBLE;
        }

        btnText1.setVisibility(visible);
        btnText2.setVisibility(visible);
        btnText3.setVisibility(visible);
        btnText4.setVisibility(visible);
    }


    public void makeQuiz(int quizNoNow) {

        answer.setText(lesson.getWordFront()[quizNoNow]);
        int j = 0;

        for(int i=0; i<4; i++) {

            // 단어 array 이에서 현재 단어포함해서 순서대로 4개의 단어를 보기로 제시함.
            if(quizNoNow + i >= wordImage.length) {
                answerArray[i] = j;
                j++;
            } else {
                answerArray[i] = quizNoNow + i;
            }
        }

        RandomArray.randomArrayInt(answerArray);

        btn1.setImageResource(wordImage[answerArray[0]]);
        btn2.setImageResource(wordImage[answerArray[1]]);
        btn3.setImageResource(wordImage[answerArray[2]]);
        btn4.setImageResource(wordImage[answerArray[3]]);

        btnText1.setText(lesson.getWordBack()[answerArray[0]]);
        btnText2.setText(lesson.getWordBack()[answerArray[1]]);
        btnText3.setText(lesson.getWordBack()[answerArray[2]]);
        btnText4.setText(lesson.getWordBack()[answerArray[3]]);

        setEngHint(engHint);

        mediaPlayerManager.setMediaPlayerByte(false, activity.wordAudioByte.get(quizNoNow));
    }


    public void makeNextQuiz(final View selectedBtn, final boolean isCorrect) {

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                try {
                    selectedBtn.setBackground(ContextCompat.getDrawable(activity, R.drawable.ripple_custom));
                } catch (NullPointerException e) {
                    System.out.println(e);
                }
                answer.setVisibility(View.GONE);
                btnAudio.setVisibility(View.VISIBLE);

                if(isCorrect) {
                    LessonFrame.progressCount++;
                    LessonFrame.progressCount();
                }

                if(solveWrongQuizAgain) {
                    // 오답이 있을 경우, 해당 문제 다시 출력
                    if(wrongQuizList.size() > 0) {
                        makeWrongQuiz(wrongQuizList.get(0));
                    } else {
                        // 퀴즈2로 넘어가기
                        activity.replaceFragment(LessonWordQuiz2.newInstance());
                    }
                } else {

                    quizNoNow ++;
                    if(quizNoNow == quizQuantity-1) {
                        solveWrongQuizAgain = true;
                    }
                    makeQuiz(quizNoNow);
                }
            }
        }, 2000);
    }


    public void makeWrongQuiz(int wrongQuizNo) {

        wrongQuizList.remove(0);
        quizNoNow = wrongQuizNo;
        makeQuiz(quizNoNow);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnAudio :
                mediaPlayerManager.playMediaPlayer(false);
                break;


            default:

                int selectedBtnNo;

                if(view.getId() == R.id.btn1) {
                    selectedBtnNo = 0;
                } else if(view.getId() == R.id.btn2) {
                    selectedBtnNo = 1;
                } else if(view.getId() == R.id.btn3) {
                    selectedBtnNo = 2;
                } else {
                    selectedBtnNo = 3;
                }

                if(lesson.getWordBack()[quizNoNow].equals(lesson.getWordBack()[answerArray[selectedBtnNo]])) {
                    answered(view, 0, R.drawable.bg_white_10_stroke_purple, true);
                } else {
                    wrongQuizList.add(quizNoNow);
                    answered(view, 1, R.drawable.bg_white_10_stroke_red, false);
                }
                break;
        }
    }


    // 정답/오답 소리 출력하고 선택한 이미지에 파란색/빨간색 테두리
    private void answered(View view, int sound, int outline, boolean isCorrect) {
        playSoundPool.playSoundLesson(sound);
        view.setBackground(ContextCompat.getDrawable(activity, outline));
        answer.setVisibility(View.VISIBLE);
        btnAudio.setVisibility(View.GONE);

        makeNextQuiz(view, isCorrect);
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
