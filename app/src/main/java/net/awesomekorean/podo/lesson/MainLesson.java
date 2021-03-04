package net.awesomekorean.podo.lesson;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.awesomekorean.podo.EventTimer;
import net.awesomekorean.podo.PlaySoundPool;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UnixTimeStamp;
import net.awesomekorean.podo.UserInformation;
import net.awesomekorean.podo.challenge.Challenge;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson00;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson01;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson02;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson03;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson04;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson05;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson06;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson07;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson08;
import net.awesomekorean.podo.lesson.intermediateLessons.I_Lesson09;
import net.awesomekorean.podo.lesson.lessonHangul.LessonHangul;
import net.awesomekorean.podo.lesson.lessonHangul.LessonHangulBatchim;
import net.awesomekorean.podo.lesson.lessonHangul.LessonHangulConsonant;
import net.awesomekorean.podo.lesson.lessonHangul.LessonHangulVowel;
import net.awesomekorean.podo.lesson.lessonNumber.LessonNumber;
import net.awesomekorean.podo.lesson.lessonNumber.numbers.NumberNative;
import net.awesomekorean.podo.lesson.lessonNumber.numbers.NumberSino;
import net.awesomekorean.podo.lesson.lessonReviewRewards.LessonReview00;
import net.awesomekorean.podo.lesson.lessonReviewRewards.LessonReview01;
import net.awesomekorean.podo.lesson.lessonReviewRewards.LessonReview02;
import net.awesomekorean.podo.lesson.lessonReviewRewards.LessonReview03;
import net.awesomekorean.podo.lesson.lessonReviewRewards.LessonReview04;
import net.awesomekorean.podo.lesson.lessonReviewRewards.LessonReview05;
import net.awesomekorean.podo.lesson.lessonReviewRewards.LessonReview06;
import net.awesomekorean.podo.lesson.lessonReviewRewards.Rewards00;
import net.awesomekorean.podo.lesson.lessonReviewRewards.Rewards01;
import net.awesomekorean.podo.lesson.lessonReviewRewards.Rewards02;
import net.awesomekorean.podo.lesson.lessonReviewRewards.Rewards03;
import net.awesomekorean.podo.lesson.lessonReviewRewards.Rewards04;
import net.awesomekorean.podo.lesson.lessonReviewRewards.Rewards05;
import net.awesomekorean.podo.lesson.lessonReviewRewards.Rewards06;
import net.awesomekorean.podo.lesson.lessons.Lesson00;
import net.awesomekorean.podo.lesson.lessons.Lesson01;
import net.awesomekorean.podo.lesson.lessons.Lesson02;
import net.awesomekorean.podo.lesson.lessons.Lesson03;
import net.awesomekorean.podo.lesson.lessons.Lesson04;
import net.awesomekorean.podo.lesson.lessons.Lesson05;
import net.awesomekorean.podo.lesson.lessons.Lesson06;
import net.awesomekorean.podo.lesson.lessons.Lesson07;
import net.awesomekorean.podo.lesson.lessons.Lesson08;
import net.awesomekorean.podo.lesson.lessons.Lesson09;
import net.awesomekorean.podo.lesson.lessons.Lesson10;
import net.awesomekorean.podo.lesson.lessons.Lesson11;
import net.awesomekorean.podo.lesson.lessons.Lesson12;
import net.awesomekorean.podo.lesson.lessons.Lesson13;
import net.awesomekorean.podo.lesson.lessons.Lesson14;
import net.awesomekorean.podo.lesson.lessons.Lesson15;
import net.awesomekorean.podo.lesson.lessons.Lesson16;
import net.awesomekorean.podo.lesson.lessons.Lesson17;
import net.awesomekorean.podo.lesson.lessons.Lesson18;
import net.awesomekorean.podo.lesson.lessons.Lesson19;
import net.awesomekorean.podo.lesson.lessons.Lesson20;
import net.awesomekorean.podo.lesson.lessons.Lesson21;
import net.awesomekorean.podo.lesson.lessons.Lesson22;
import net.awesomekorean.podo.lesson.lessons.Lesson23;
import net.awesomekorean.podo.lesson.lessons.Lesson24;
import net.awesomekorean.podo.lesson.lessons.Lesson25;
import net.awesomekorean.podo.lesson.lessons.Lesson26;
import net.awesomekorean.podo.lesson.lessons.Lesson27;
import net.awesomekorean.podo.lesson.lessons.Lesson28;
import net.awesomekorean.podo.lesson.lessons.Lesson29;
import net.awesomekorean.podo.lesson.lessons.Lesson30;
import net.awesomekorean.podo.lesson.lessons.Lesson31;
import net.awesomekorean.podo.lesson.lessons.Lesson32;
import net.awesomekorean.podo.lesson.lessons.Lesson33;
import net.awesomekorean.podo.lesson.lessons.Lesson34;
import net.awesomekorean.podo.lesson.lessons.Lesson35;
import net.awesomekorean.podo.lesson.lessons.Lesson36;
import net.awesomekorean.podo.lesson.lessons.Lesson37;
import net.awesomekorean.podo.lesson.lessons.Lesson38;
import net.awesomekorean.podo.lesson.lessons.Lesson39;
import net.awesomekorean.podo.lesson.lessons.Lesson40;
import net.awesomekorean.podo.lesson.lessons.Lesson41;
import net.awesomekorean.podo.lesson.lessons.Lesson42;
import net.awesomekorean.podo.lesson.lessons.Lesson43;
import net.awesomekorean.podo.lesson.lessons.Lesson44;
import net.awesomekorean.podo.lesson.lessons.Lesson45;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class MainLesson extends Fragment implements View.OnClickListener {

    Context context;
    View view;
    ImageView btnPreLevel;
    TextView tvLevel;
    ImageView btnNextLevel;
    ImageView ivBackGround;

    UserInformation userInformation;
    RecyclerView recyclerView;
    LessonAdapter adapter;
    SeekBar seekBar;

    LessonItem[] beginner = {
            new LessonHangul(), new Lesson00(), new Lesson01(), new Lesson02(), new Lesson19(), new Lesson03(), new LessonReview00(), new Rewards00(),
            new LessonNumber(), new Lesson04(), new Lesson05(), new Lesson06(), new Lesson07(), new Lesson08(), new Lesson27(), new LessonReview01(), new Rewards01(),
            new Lesson09(), new Lesson10(), new Lesson11(), new Lesson12(), new Lesson13(), new Lesson14(), new Lesson15(), new Lesson16(), new LessonReview02(), new Rewards02(),
            new Lesson22(), new Lesson28(), new Lesson29(), new Lesson17(), new Lesson20(), new Lesson18(), new Lesson21(), new Lesson23(), new Lesson35(), new LessonReview03(), new Rewards03(),
            new Lesson24(), new Lesson25(), new Lesson26(), new Lesson30(), new Lesson31(), new Lesson32(), new Lesson33(), new Lesson34(), new LessonReview04(), new Rewards04(),
            new Lesson36(), new Lesson37(), new Lesson38(), new Lesson39(), new Lesson40(), new LessonReview05(), new Rewards05(),
            new Lesson41(), new Lesson42(), new Lesson43(), new Lesson44(), new Lesson45(), new LessonReview06(), new Rewards06()
    };

    LessonItem[] intermediate = {
            new I_Lesson00(), new I_Lesson01(), new I_Lesson02(), new I_Lesson03(), new I_Lesson04(),
            new I_Lesson05(), new I_Lesson06(), new I_Lesson07(), new I_Lesson08(), new I_Lesson09()
    };

    ArrayList<LessonItem> list = new ArrayList<>();

    ImageView btnInfo;
    ConstraintLayout layoutInfo;
    Button btnCloseInfo;

    int lastClickLevel;

    ConstraintLayout btnChallenge;
    ConstraintLayout layoutChallengeProgress;
    TextView challengeCount;
    TextView countDayChallenge;
    TextView textProgressChallenge;
    ProgressBar progressChallenge;
    ImageView starsA;
    ImageView starsB;

    ConstraintLayout challengeResult;
    TextView titleChallengeResult;
    TextView challengeRewardPoints;
    TextView challengeResultMessage;
    Button btnCloseChallengeResult;

    int specialLessonCount;

    EventTimer eventTimer;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_lesson, container, false);
        btnPreLevel = view.findViewById(R.id.btnPreLevel);
        ivBackGround = view.findViewById(R.id.ivBackGround);
        tvLevel = view.findViewById(R.id.tvLevel);
        btnNextLevel = view.findViewById(R.id.btnNextLevel);
        btnInfo = view.findViewById(R.id.btnInfo);
        layoutInfo = view.findViewById(R.id.layoutInfo);
        btnCloseInfo = view.findViewById(R.id.btnCloseInfo);
        seekBar = view.findViewById(R.id.seekBar);
        btnChallenge = view.findViewById(R.id.btnChallenge);
        layoutChallengeProgress = view.findViewById(R.id.layoutChallengeProgress);
        challengeCount = view.findViewById(R.id.challengeCount);
        countDayChallenge = view.findViewById(R.id.countDayChallenge);
        textProgressChallenge = view.findViewById(R.id.textProgressChallenge);
        progressChallenge = view.findViewById(R.id.progressChallenge);
        starsA = view.findViewById(R.id.starsA);
        starsB = view.findViewById(R.id.starsB);
        challengeResult = view.findViewById(R.id.challengeResult);
        titleChallengeResult = view.findViewById(R.id.titleChallengeResult);
        challengeRewardPoints = view.findViewById(R.id.challengeRewardPoints);
        challengeResultMessage = view.findViewById(R.id.challengeResultMessage);
        btnCloseChallengeResult = view.findViewById(R.id.btnCloseChallengeResult);
        btnPreLevel.setOnClickListener(this);
        btnNextLevel.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
        btnCloseInfo.setOnClickListener(this);
        btnCloseChallengeResult.setOnClickListener(this);

        context = getContext();
        userInformation = SharedPreferencesInfo.getUserInfo(context);
        setLessonItem(lastClickLevel);
        adapter = new LessonAdapter(context, list);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        int isChallenger = userInformation.getIsChallenger();

        // 챌린저 진행중
        if(isChallenger == 1) {
            setChallengeVisible(GONE, VISIBLE);
            setChallengeInfo();


        // 챌린지 종료
        } else if(isChallenger == 2) {
            setChallengeVisible(GONE, GONE);

            // 챌린지 보상여부 체크
            if(userInformation.getIsChallengeRewarded() == 0) {
                int completeLessonSize = checkCompleteLessonNo();
                int totalLessonSize = beginner.length + intermediate.length;
                int rewardPoint;
                System.out.println("완료레슨 : " + completeLessonSize);
                System.out.println("토탈레슨 : " + totalLessonSize);
                if(completeLessonSize >= totalLessonSize ) {
                    System.out.println("챌린지 성공!");
                    PlaySoundPool playSoundPool = new PlaySoundPool(context);
                    playSoundPool.playSoundYay();
                    userInformation.setIsChallengeRewarded(1);
                    titleChallengeResult.setText(getString(R.string.CONGRATULATION));
                    rewardPoint = 1000;
                    challengeRewardPoints.setText(String.valueOf(rewardPoint));
                    challengeResultMessage.setText(getString(R.string.CHALLENGE_SUCCEED_MESSAGE));

                } else {
                    System.out.println("챌린지 실패!");
                    userInformation.setIsChallengeRewarded(2);
                    titleChallengeResult.setText(getString(R.string.CHALLENGE_FAILED));
                    rewardPoint = 100;
                    challengeRewardPoints.setText(String.valueOf(rewardPoint));
                    challengeResultMessage.setText(getString(R.string.CHALLENGE_FAILED_MESSAGE));
                }
                challengeResult.setVisibility(VISIBLE);
                userInformation.addRewardPoints(context, rewardPoint);
            }

        // 챌린저 아님
        } else {
            checkEventTimer();
            setChallengeVisible(VISIBLE, GONE);
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.blink_infinite);
            starsA.startAnimation(animation);
            starsB.startAnimation(animation);
        }



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                recyclerView.scrollToPosition(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        int lastClickItem = SharedPreferencesInfo.getLastClickItem(context, true);
        recyclerView.scrollToPosition(lastClickItem);
        return view;
    }


    // 챌린지 버튼 세팅
    private void setChallengeVisible(int a, int b) {
        btnChallenge.setVisibility(a);
        layoutChallengeProgress.setVisibility(b);
        if(a == GONE) {
            starsA.setVisibility(GONE);
            starsB.setVisibility(GONE);
        }
    }


    // 이벤트 타이머 확인 (비챌린저)
    private void checkEventTimer() {
        challengeCount.setVisibility(GONE);
        System.out.println("이벤트 타이머를 확인합니다.");
        SharedPreferences sp = SharedPreferencesInfo.getEventTimer(context);
        boolean isWorking = sp.getBoolean("isWorking", false);
        final Intent intent = new Intent(context, Challenge.class);

        if(isWorking) {
            System.out.println("이벤트 타이머가 작동중입니다.");
            long timeNow = UnixTimeStamp.getTimeNow();
            long startTime = sp.getLong("startTime", 0);
            long eventTime = sp.getLong("eventTime", 0);
            long passedTime = timeNow - startTime;

            // 타이머 작동
            if(passedTime < eventTime) {
                challengeCount.setVisibility(VISIBLE);

                final String DISCOUNT = "discount";
                int percent = sp.getInt("percent", 0);

                eventTimer = new EventTimer(context, eventTime - passedTime, challengeCount, intent);
                intent.putExtra(DISCOUNT, percent);

            } else {
                SharedPreferencesInfo.setEventTimer(context, 0, 0);
            }
        }

        btnChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(intent, 200);
            }
        });
    }


    // 챌린저 정보 세팅
    private void setChallengeInfo() {
        Long timeStart = userInformation.getDateChallengeStart();
        Long timeNow = UnixTimeStamp.getTimeNow();
        int dayCount = (int) Math.floor((timeNow-timeStart)/86400 + 1);
        countDayChallenge.setText(Integer.toString(dayCount));
        int totalLessonNo = beginner.length + intermediate.length;
        int completeLessonNo = checkCompleteLessonNo();
        int percent = completeLessonNo *100  / totalLessonNo;
        textProgressChallenge.setText(completeLessonNo + " / " + (totalLessonNo));
        progressChallenge.setProgress(percent);
    }


    // 완료레슨 개수 확인하기 (챌린저)
    private int checkCompleteLessonNo() {
        if(userInformation == null) {
            userInformation = SharedPreferencesInfo.getUserInfo(getContext());
        }
        List<String> lessonComplete = userInformation.getLessonComplete();
        int count = 0;
        for(LessonItem item : beginner) {
            if(lessonComplete.contains(item.getLessonId())) {
                count++;
            }
        }
        for(LessonItem item : intermediate) {
            if(lessonComplete.contains(item.getLessonId())) {
                count++;
            }
        }
        return count;
    }


    private void setLessonItem(int level) {
        list.clear();

        if(level == 0) {
            for(LessonItem item : beginner) {
                list.add(item);
            }

        } else if(level == 1) {
            for(LessonItem item : intermediate) {
                list.add(item);
            }
        }
        seekBar.setMax(list.size());
        setLevelDesign(level);
        setCompletedLessons();
        setUnlockedLessons();
    }


    // 레슨 활성/완료 세팅하기
    private void setCompletedLessons() {
        if(userInformation == null) {
            userInformation = SharedPreferencesInfo.getUserInfo(getContext());
        }
        List<String> lessonComplete = userInformation.getLessonComplete();
        System.out.println("LESSON_COMPLETE:" + lessonComplete);
        int isChallenger = userInformation.getIsChallenger();

        // 챌린저 아닐 때
        if(isChallenger == 0) {
            if (lessonComplete.size() > 0) {
                for (int i = 0; i < list.size(); i++) {
                    if (lessonComplete.contains(list.get(i).getLessonId())) {
                        list.get(i).setIsCompleted(true);
                        list.get(i).setIsLocked(false);
                        list.get(i).setIsActive(true);
                        list.get(i).setIsCurrent(false);
                        if (i < list.size() - 1) {
                            list.get(i + 1).setIsActive(true);
                            list.get(i + 1).setIsCurrent(true);
                        }

                        // 스페셜레슨 세팅
                        if (list.get(i).getSLesson() != null) {
                            list.get(i).getSLesson().setIsActive(true);

                            if (lessonComplete.contains(list.get(i).getSLesson().getLessonId())) {
                                list.get(i).getSLesson().setIsCompleted(true);
                            }
                        }
                    }
                }

            } else {
                list.get(0).setIsCurrent(true);
            }

        // 챌린저일 때
        } else {
            specialLessonCount = 0;
            for (int i = 0; i < list.size(); i++) {
                list.get(i).setIsLocked(false);
                if (list.get(i).getSLesson() != null) {
                    list.get(i).getSLesson().setIsLocked(false);
                    specialLessonCount ++;
                }

                if (lessonComplete.contains(list.get(i).getLessonId())) {
                    list.get(i).setIsCompleted(true);
                    list.get(i).setIsActive(true);
                    list.get(i).setIsCurrent(false);
                    if (i < list.size() - 1) {
                        list.get(i + 1).setIsActive(true);
                        list.get(i + 1).setIsCurrent(true);
                    }

                    // 스페셜레슨 세팅
                    if (list.get(i).getSLesson() != null) {
                        list.get(i).getSLesson().setIsActive(true);

                        if (lessonComplete.contains(list.get(i).getSLesson().getLessonId())) {
                            list.get(i).getSLesson().setIsCompleted(true);
                        }
                    }
                }
            }
        }
        list.get(0).setIsActive(true);
    }


    // 구매된 스페셜 & 레슨 세팅하기
    private void setUnlockedLessons() {
        List<String> specialLessonUnlock = userInformation.getSpecialLessonUnlock();
        List<String> lessonUnlock = userInformation.getLessonUnlock();
        System.out.println("S_LESSON_UNLOCK:" + specialLessonUnlock);
        System.out.println("LESSON_UNLOCK:" + lessonUnlock);


        if(specialLessonUnlock != null) {
            for(int i=0; i<list.size(); i++) {
                if (list.get(i).getSLesson() != null && specialLessonUnlock.contains(list.get(i).getSLesson().getLessonId())) {
                    list.get(i).getSLesson().setIsLocked(false);
                    list.get(i).getSLesson().setIsActive(true);
                }
            }
        }

        if(lessonUnlock != null) {
            for(int i=0; i<list.size(); i++) {
                if (lessonUnlock.contains(list.get(i).getLessonId())) {
                    list.get(i).setIsLocked(false);
                    list.get(i).setIsActive(true);
                }
            }
        }
    }


    // 레슨레벨 세팅하기
    private void setLevelDesign(int thisLevel) {
        switch (thisLevel) {
            case 0 :    // 초급레슨
                tvLevel.setText(getResources().getString(R.string.BEGINNER_LEVEL));
                tvLevel.setTextColor(ContextCompat.getColor(context, R.color.PURPLE));
                ivBackGround.setImageResource(R.drawable.bg_light_blue);
                btnPreLevel.setVisibility(View.INVISIBLE);
                btnNextLevel.setVisibility(VISIBLE);
                break;

            case 1 :    // 중급레슨
                tvLevel.setText(getResources().getString(R.string.INTERMEDIATE_LEVEL));
                tvLevel.setTextColor(ContextCompat.getColor(context, R.color.BLUE));
                ivBackGround.setImageResource(R.drawable.bg_pink);
                btnPreLevel.setVisibility(VISIBLE);
                btnNextLevel.setVisibility(View.INVISIBLE);
                break;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPreLevel :
                setLessonItem(0);
                adapter.notifyDataSetChanged();
                break;

            case R.id.btnNextLevel :
                setLessonItem(1);
                adapter.notifyDataSetChanged();
                break;

            case R.id.btnInfo :
                layoutInfo.setVisibility(VISIBLE);
                break;

            case R.id.btnCloseInfo :
                layoutInfo.setVisibility(GONE);
                break;

            case R.id.btnCloseChallengeResult :
                challengeResult.setVisibility(GONE);
                break;
        }
    }


    // 챌린지 구매 완료 시
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK) {
            userInformation = SharedPreferencesInfo.getUserInfo(context);
            if(userInformation.getIsChallenger() == 1) {
                setChallengeInfo();
                setChallengeVisible(GONE, VISIBLE);
                SharedPreferencesInfo.setEventTimer(context, 0, 0);
                if(eventTimer != null) {
                    eventTimer.onFinish();
                }
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        userInformation = SharedPreferencesInfo.getUserInfo(context);

        if(adapter != null) {
            System.out.println("메인레슨 보임!");
            lastClickLevel = SharedPreferencesInfo.getLastClickLevel(context);
            setLessonItem(lastClickLevel);
            adapter.notifyDataSetChanged();
        }

        if(userInformation.getIsChallenger() == 1) {
            setChallengeInfo();
            setChallengeVisible(GONE, VISIBLE);
        }
    }
}


