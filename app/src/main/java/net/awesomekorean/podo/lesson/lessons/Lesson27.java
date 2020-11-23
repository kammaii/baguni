package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson27 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_27";
    private String lessonTitle = "because, so";
    private String lessonSubTitle = "~아/어서";
    private LessonItem specialLesson = new S_Lesson08();
    private Integer dayCount = 7;

    private String[] wordFront = {"살다", "싸다", "비싸다", "사다", "팔다", "하지만"};

    private String[] wordBack = {"live in", "cheap", "expensive", "buy", "sell", "however"};

    private String[] wordPronunciation = {"-", "-", "-", "-", "-", "-"};

    private String[] sentenceFront = {
            "저는 살고 있어요.",
            "저는 태국에서 살고 있어요.",
            "많이 사요.",
            "망고가 아주 싸서 많이 사요.",
            "태국에는 망고가 아주 싸서 많이 사요.",
            "태국 망고를 팔아요.",
            "한국에도 태국 망고를 팔아요.",
            "못 사요.",
            "너무 비싸서 못 사요."
    };

    private String[] sentenceBack = {
            "I live.",
            "I live in thailand.",
            "I buy it a lot.",
            "Mango is very cheap so I buy it a lot.",
            "Mango is very cheap in Thailand so I buy it a lot.",
            "They sell Thai mango.",
            "They sell Thai mango in Korea as well.",
            "I can't buy it.",
            "It is very expensive so I can't buy."
    };

    private String[] sentenceExplain = {
            "'살다'  -> '살' + '고 있다' = '살고 있다'",
            "-",
            "-",
            "Don't be confused.\n'사다 ' -> '사요'  (to buy)\n'살다' -> '살아요'  (to live)\n\nWhen you want to say the reason, use the '아/어서' form.\n'싸요' -> '싸' + '서' = '싸서'\n\nYou can also use '(으)니까' form in the same way.\n'싸다' -> '싸' + '니까' = '싸니까'\n\n(See the Lesson 6 - confusing expression : '아/어서' vs '으니까')",
            "-",
            "-",
            "'도' means 'also'.",
            "The Batchim 'ㅅ' of '못' can affect to the consonant 'ㅅ' of '사요' so you may can hear 'ㅆ' sound.",
            "'비싸요' -> '비싸' + '서' = '비싸서'\n\n'비싸다' -> '비싸' + '니까' = '비싸니까'"
    };

    private String[] dialog = {
            "저는 태국에서 살고 있어요\n태국에는 망고가 아주 싸서 많이 사요.",
            "한국에도 태국 망고를 팔아요.\n하지만 너무 비싸서 못 사요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {1,6};


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
    public LessonItem getSLesson() {
        return specialLesson;
    }

    @Override
    public Integer getDayCount() {
        return dayCount;
    }
}
