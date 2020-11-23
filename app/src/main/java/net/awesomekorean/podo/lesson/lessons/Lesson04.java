package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson04 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_04";
    private String lessonTitle = "past";
    private String lessonSubTitle = "~았/었어요";

    private String[] wordFront = {"어제", "집", "아니요", "쇼핑"};

    private String[] wordBack = {"yesterday", "home / house", "no", "shopping"};

    private String[] wordPronunciation = {"-", "-", "-", "-"};

    private String[] sentenceFront = {
            "있다",
            "있어요",
            "있었어요?",
            "집에 있었어요?",
            "어제 집에 있었어요?",
            "아니요.",
            "하다",
            "해요",
            "했어요?",
            "뭐 했어요?",
            "어제 뭐 했어요?",
            "쇼핑 했어요."
    };

    private String[] sentenceBack = {
            "to be",
            "to be",
            "Were you?",
            "Were you at home?",
            "Were you at home yesterday?",
            "no",
            "do",
            "do",
            "Did you do?",
            "What did you do?",
            "What did you do yesterday?",
            "I went shopping."
    };

    private String[] sentenceExplain = {
            "-",
            "conjugate '아요/어요'\n: '있다' -> '있' + '어요' = '있어요'",
            "When you use past tense, you only need to put 'ㅆ어' into the form of '아요/어요'.\nTherefore, you can use the past tense as '았어요/었어요' form.\n'있어요' -> '있어(ㅆ어)요' = '있었어요'",
            "-",
            "-",
            "-",
            "-",
            "conjugate '아요/어요'\n: '하다' -> '해요'",
            "'해요' -> '해(ㅆ어)요' = '했어요'",
            "-",
            "-",
            "-"
    };

    private String[] dialog = {
            "어제 집에 있었어요?",
            "아니요.",
            "어제 뭐 했어요?",
            "쇼핑 했어요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {4,10,11};


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
