package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson41 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_41";
    private String lessonTitle = "promise";
    private String lessonSubTitle = "~기로 했어요";

    private String[] wordFront = {"돌아가다", "벌써", "빠르다", "느리다", "부모님"};

    private String[] wordBack = {"go back", "already", "fast", "slow", "parents"};

    private String[] wordPronunciation = {"[도라가다]", "-", "-", "-", "-"};

    private String[] sentenceFront = {
            "저 한국에 돌아가요.",
            "저 다음 주에 한국에 돌아가요.",
            "빠르게 가는 것 같아요.",
            "시간이 정말 빠르게 가는 것 같아요.",
            "뭐 할 거예요?",
            "한국에 돌아가면 뭐 할 거예요?",
            "도와주기로 했어요.",
            "부모님 일을 도와주기로 했어요."
    };

    private String[] sentenceBack = {
            "I'm going back to Korea.",
            "I'm going back to Korea next week.",
            "It seems like time goes fast.",
            "I think time is going really fast.",
            "What are you going to do?",
            "What are you going to do when you go back to Korea?",
            "I'll help.",
            "I'll help my parents business."
    };

    private String[] sentenceExplain = {
            "The honorific of '나' is '저'.\n\n'돌다' : turn\n'가다' : go\n'돌아가다' : turn and go = go back",
            "-",
            "When you want to transform an adjective into an adverb, you can use the '-게' form.\n'빠르다' -> '빠르' + '게' = '빠르게'",
            "-",
            "-",
            "-",
            "-",
            "When talking about an appointment with another person or resolution for yourself, you can use '~기로 했어요'.\nUsually Korean use it a lot when talking about a schedule or plan."
    };

    private String[] dialog = {
            "저 다음 주에 한국에 돌아가요.",
            "벌써요? 시간이 정말 빠르게 가는 것 같아요. 한국에 돌아가면 뭐 할 거예요?",
            "부모님 일을 도와주기로 했어요."
    };

    private int[] peopleImage = {R.drawable.female_b,R.drawable.male_p};

    private int[] reviewId = {1,3,5,7};


    @Override
    public String getLessonSubTitle() {
        return lessonSubTitle;
    }

    @Override
    public String getLessonId() {
        return lessonId;
    }

    @Override
    public String[] getWordFront() {
        return wordFront;
    }

    @Override
    public String[] getWordPronunciation() {
        return wordPronunciation;
    }

    @Override
    public String[] getSentenceFront() {
        return sentenceFront;
    }

    @Override
    public String[] getDialog() {
        return dialog;
    }

    @Override
    public int[] getPeopleImage() {
        return peopleImage;
    }

    @Override
    public String[] getWordBack() {
        return wordBack;
    }

    @Override
    public String[] getSentenceBack() {
        return sentenceBack;
    }

    @Override
    public String[] getSentenceExplain() {
        return sentenceExplain;
    }

    @Override
    public int[] getReviewId() {
        return reviewId;
    }


    // 레슨어뎁터 아이템

    @Override
    public String getLessonTitle() {
        return lessonTitle;
    }
}
