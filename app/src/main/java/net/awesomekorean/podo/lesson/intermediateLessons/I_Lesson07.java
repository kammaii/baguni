package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson07 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_07";
    private String lessonTitle = "Asking for directions";
    private String lessonSubTitle = "길 묻기";
    private Integer dayCount = 29;

    private String[] dialog = {
            "네?",
            "저… 죄송한데, 서울역이 어디에 있어요?",
            "저기 은행 보여요?",
            "네.",
            "저 은행에서 왼쪽으로 가면 돼요.",
            "얼마나 가야 돼요?",
            "5분정도 가면 돼요.",
            "그리고 이 근처에 서점 있어요?",
            "서점은 서울역 앞에 있어요.",
            "정말 고맙습니다.",
            "아니에요. 괜찮아요."
    };

    private String[] dialogEng = {
            "Yes?",
            "Excuse me but, where is Seoul Station?",
            "Do you see the bank over there?",
            "Yes.",
            "You can go left at that bank.",
            "How long does it take?",
            "It takes about 5 minutes.",
            "And is there any bookstore around here?",
            "The bookstore is in the Seoul Station.",
            "Thank you very much.",
            "It's okay."
    };

    private int[] peopleImage = {R.drawable.pedestrian_b, R.drawable.female_p};

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
