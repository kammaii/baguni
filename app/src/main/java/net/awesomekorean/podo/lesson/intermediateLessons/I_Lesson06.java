package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson06 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_06";
    private String lessonTitle = "check-in";
    private String lessonSubTitle = "호텔 체크인";

    private String[] dialog = {
            "어서 오세요.",
            "체크인(check-in)이요.",
            "여권 주세요.",
            "네, 여기요.",
            "감사합니다. 잠시만 기다려주세요.",
            "네.",
            "기다려 주셔서 감사합니다. 방은 1234호입니다.",
            "아침은 몇 시부터 먹을 수 있어요?",
            "6시부터 10시까지입니다.",
            "체크아웃(check-out)은 몇 시까지예요?",
            "오전 11시까지입니다."
    };

    private String[] dialogEng = {
            "Welcome.",
            "Check-in, please.",
            "Please give me your passport.",
            "OK, here.",
            "Thank you. Please wait.",
            "Yes.",
            "Thank you for waiting. Your room number is 1234.",
            "What time can I eat breakfast?",
            "It is from 6 to 10.",
            "What time is check-out?",
            "It is until 11 am."
    };

    private int[] peopleImage = {R.drawable.hotel_front_b, R.drawable.male_p};

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
