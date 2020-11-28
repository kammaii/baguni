package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson05 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_05";
    private String lessonTitle = "immigration";
    private String lessonSubTitle = "입국 심사";
    private Integer dayCount = 28;

    private String[] dialog = {
            "여권 주세요.",
            "네, 여기요.",
            "한국에 왜 왔어요?",
            "여행 왔어요.",
            "혼자 왔어요?",
            "아니요, 가족이랑 왔어요.",
            "전에 한국에 와 본 적 있어요?",
            "아니요, 처음이에요.",
            "한국에 얼마나 있을 거예요?",
            "1주 동안 있을 거예요.",
            "어디에서 있을 거예요?",
            "호텔에서 있을 거예요.",
            "네, 끝났습니다.",
            "고맙습니다."
    };

    private String[] dialogEng = {
            "May I have your passport please?",
            "Yes, here it is.",
            "Why did you come to Korea?",
            "I'm here to travel.",
            "Did you come alone?",
            "No, I came with my family.",
            "Have you been to Korea before?",
            "No, this is my first time.",
            "How long will you stay in Korea?",
            "I’ll stay for a week.",
            "Where will you stay?",
            "I’ll stay at the hotel.",
            "Yes, it is done.",
            "Thank you."
    };

    private int[] peopleImage = {R.drawable.immigrant_b, R.drawable.female_p};

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
