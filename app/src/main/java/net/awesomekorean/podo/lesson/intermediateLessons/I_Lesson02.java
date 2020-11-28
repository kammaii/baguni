package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson02 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_02";
    private String lessonTitle = "taxi";
    private String lessonSubTitle = "택시 타기";

    private String[] dialog = {
            "어디로 가세요?",
            "서울역으로 가 주세요.",
            "네.",
            "얼마나 걸려요?",
            "지금 차가 많아서 30분쯤 걸릴 것 같아요.",
            "더 빨리 갈 수 있어요?",
            "왜요? 기차 타야 돼요?",
            "네, 40분 후에 출발해요.",
            "네, 빨리 갈게요.",
            "고맙습니다.",
            "(잠시 후)",
            "여기에서 내려주세요.",
            "네."
    };

    private String[] dialogEng = {
            "Where are you going?",
            "Please go to Seoul Station.",
            "Yes.",
            "How long does it take?",
            "Due to the traffic jam, it will take about 30 minutes.",
            "Can you make it faster?",
            "Why? Do you need to catch the train?",
            "Yes, it departs in 40 minutes.",
            "Okay, I'll take the quickest way.",
            "Thank you.",
            "(After a while)",
            "Please drop me off here.",
            "Yes."
    };

    private int[] peopleImage = {R.drawable.taxi_driver_b, R.drawable.female_p};

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
