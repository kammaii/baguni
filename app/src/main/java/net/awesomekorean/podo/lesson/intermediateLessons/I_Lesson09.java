package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson09 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_09";
    private String lessonTitle = "Korea Travel Story";
    private String lessonSubTitle = "한국여행 이야기";
    private Integer dayCount = 30;

    private String[] dialog = {
            "한국에 가 본 적 있어요?",
            "네, 작년에 한번 가 본 적 있어요.",
            "얼마나 있었어요?",
            "4일동안 있었어요.",
            "누구랑 갔어요?",
            "친구 2명이랑 같이 갔어요.",
            "한국 어디에 갔어요?",
            "서울이랑 부산에 갔어요.",
            "서울은 어때요?",
            "서울에는 재미있는 것이 많아요.",
            "부산은 어때요?",
            "부산에는 맛있는 것이 많아요.",
            "날씨는 어땠어요?",
            "겨울이어서 조금 추웠지만 괜찮았어요.",
            "또 가고 싶어요?",
            "네, 내년에 또 갈 거예요."
    };

    private String[] dialogEng = {
            "Have you ever been to Korea?",
            "Yes, I've been there once last year.",
            "How long have you been?",
            "I've been there for 4 days.",
            "Who did you go with?",
            "I went with 2 friends.",
            "Where have you been in Korea?",
            "I went to Seoul and Busan.",
            "How about Seoul?",
            "There are a lot of fun things in Seoul.",
            "How about Busan?",
            "There are many delicious things in Busan.",
            "How was the weather?",
            "It was a little cold because it was winter, but it was okay.",
            "Do you want to go again?",
            "Yes, I will go again next year."
    };

    private int[] peopleImage = {R.drawable.friend_b, R.drawable.male_p};

    @Override
    public String getLessonSubTitle() {
        return lessonSubTitle;
    }

    @Override
    public String getLessonId() {
        return lessonId;
    }

    @Override
    public String[] getDialog() {
        return dialog;
    }

    @Override
    public String[] getDialogEng() {
        return dialogEng;
    }

    @Override
    public int[] getPeopleImage() {
        return peopleImage;
    }



    // 레슨어뎁터 아이템

    @Override
    public String getLessonTitle() {
        return lessonTitle;
    }

    @Override
    public Integer getDayCount() {
        return dayCount;
    }
}
