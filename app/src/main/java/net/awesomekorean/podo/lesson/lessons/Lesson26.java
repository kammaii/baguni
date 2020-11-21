package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson26 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_26";
    private String lessonTitle = "have done";
    private String lessonSubTitle = "~아/어 본 적 있다";
    private Integer dayCount = 16;

    private String[] wordFront = {"작년", "올해", "내년", "봄", "여름", "가을", "겨울"};

    private String[] wordBack = {"last year", "this year", "next year", "spring", "summer", "fall", "winter"};

    private String[] wordPronunciation = {"[장년]", "-", "-", "-", "-", "-", "-"};

    private String[] sentenceFront = {
            "가 본 적 있어요?",
            "한국에 가 본 적 있어요?",
            "가 본 적 있어요.",
            "작년 봄에 가 본 적 있어요.",
            "가 봤어요?",
            "어디에 가 봤어요?",
            "한국 어디에 가 봤어요?",
            "가 봤어요.",
            "제주도에 가 봤어요.",
            "서울이랑 제주도에 가 봤어요."
    };

    private String[] sentenceBack = {
            "Have you been there?",
            "Have you been to Korea?",
            "I've been there.",
            "I've been there last spring.",
            "Have you been there?",
            "Where have you been?",
            "Which part of Korea have you been?",
            "I've been there.",
            "I've been to Jeju Island.",
            "I've been to Seoul and Jeju Island."
    };

    private String[] sentenceExplain = {
            "'가다' -> '가' + '본 적 있다' = '가 본 적 있다'",
            "-",
            "-",
            "'작년 봄'(time) + '에'",
            "If you use the '아/어 보다' that we learned from the last lesson as a past tense, it means 'experience'.\nTherefore, you can use the same meaning of '아/어 봤다' and '아/어 본 적 있다.'\n\nBoth are often used in the actual conversation, so it's good to learn them all.",
            "-",
            "Be careful not to write '한국에 어디에'.\n'에' only needs to be written once at the end.",
            "-",
            "-",
            "'울' in '서울' has a Batchim, so '이랑' is added.\nIf the noun doesn't end with a Batchim, you can us '랑'\nex) 경주랑 제주도에 가봤어요."
    };

    private String[] dialog = {
            "한국에 가 본 적 있어요?",
            "네, 작년 봄에 가 본 적 있어요.",
            "한국 어디에 가 봤어요?",
            "서울이랑 제주도에 가 봤어요."
    };

    private int[] peopleImage = {12,11};

    private int[] reviewId = {1,3,6,9};


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

    @Override
    public Integer getDayCount() {
        return dayCount;
    }
}
