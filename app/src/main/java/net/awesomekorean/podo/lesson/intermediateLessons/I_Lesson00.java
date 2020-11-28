package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit;
import net.awesomekorean.podo.lesson.lessons.LessonItem;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;

import java.io.Serializable;

public class I_Lesson00 extends LessonInit implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_00";
    private String lessonTitle = "reservation";
    private String lessonSubTitle = "식당 예약";

    private String[] dialog = {
            "안녕하세요? 포도 식당입니다.",
            "안녕하세요? 오늘 저녁 예약할 수 있어요?",
            "네, 몇 시에요?",
            "저녁 6시요.",
            "몇 분이에요?",
            "네 명이요.",
            "네, 이름이 뭐예요?",
            "라일라예요.",
            "예약했습니다.",
            "고맙습니다.",
            "(몇 시간 후)",
            "안녕하세요? 오늘 예약 시간을 바꾸고 싶어요.",
            "네, 몇 시로 바꿀까요?",
            "저녁 7시요.",
            "네, 바꿨습니다.",
            "감사합니다."
    };

    private String[] dialogEng = {
            "Hello? This is ‘podo’ restaurant.",
            "Hello? Can I make a reservation tonight?.",
            "Yes, what time?",
            "6pm, please",
            "How many people?",
            "4 people.",
            "Okay, your name please?",
            "I’m Lyla.",
            "Okay.",
            "Thank you.",
            "(After a few hours)",
            "Hello? I want to change the reservation time today.",
            "Okay, what time do you prefer?",
            "7pm, please.",
            "Okay, done already.",
            "Thank you."
    };

    private int[] peopleImage = {R.drawable.waiter_b, R.drawable.female_p};

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

}
