package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson08 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_08";
    private String lessonTitle = "Conversation with Korean teacher";
    private String lessonSubTitle = "한국어 선생님과 대화";

    private String[] dialog = {
            "안녕하세요?",
            "선생님, 안녕하세요?",
            "오랜만이에요. 바빴어요?",
            "아니요. 여행 갔다 왔어요.",
            "오! 어디에 갔다 왔어요?",
            "서울이요.",
            "어땠어요?",
            "아주 재미있었어요.",
            "좋아요. 오늘 여행 단어 공부할까요?",
            "네, 좋아요.",
            "서울에 뭐 타고 갔어요?",
            "‘train’ 타고 갔어요.",
            "‘train’ 한국어로 뭐예요?",
            "음… 모르겠어요.",
            "'train'은 한국어로 ‘기차’예요.",
            "서울에 기차 타고 갔어요.",
            "잘했어요!"
    };

    private String[] dialogEng = {
            "Hello.",
            "Hello, teacher.",
            "It's been a while. Have you been busy?",
            "No. I was on a trip.",
            "Oh! Where have you been?",
            "Seoul.",
            "How was it?",
            "It was very fun.",
            "Good. Shall we study vocabulary for travel today?",
            "Yes, I like it.",
            "What did you take to go to Seoul?",
            "I took a ‘train’.",
            "What is ‘train’ in Korean?",
            "Well… I do not know.",
            "‘train’ is ‘기차’ in Korean.",
            "I took a train to Seoul.",
            "Good job!"
    };

    private int[] peopleImage = {R.drawable.korean_teacher_b, R.drawable.female_p};

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
