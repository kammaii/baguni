package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

import javax.annotation.meta.When;

public class Lesson07 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_07";
    private String lessonTitle = "do not";
    private String lessonSubTitle = "안~";

    private String[] wordFront = {"날씨", "어때요?", "여기", "조금", "춥다", "눈", "오다", "별로"};

    private String[] wordBack = {"weather", "How is it?", "here", "a bit", "cold", "snow", "come", "not that much(or many)"};

    private String[] wordPronunciation = {"-", "-", "-", "-", "[춥따]", "-", "-", "-"};

    private String[] sentenceFront = {
            "어때요?",
            "날씨가 어때요?",
            "한국 날씨가 어때요?",
            "춥다",
            "추워요.",
            "조금 추워요.",
            "오다",
            "와요?",
            "눈이 와요?",
            "와요.",
            "안 와요.",
            "눈은 안 와요.",
            "눈은 별로 안 와요."
    };

    private String[] sentenceBack = {
            "How is it?",
            "How's the weather?",
            "How's the weather in Korea?",
            "cold",
            "It's cold.",
            "It's a bit cold.",
            "come",
            "Is it coming?",
            "Is it snowing?",
            "It's coming.",
            "It's not coming.",
            "It's not snowing.",
            "It's not snowing a lot."
    };

    private String[] sentenceExplain = {
            "-",
            "-",
            "-",
            "-",
            "conjugate '아요/어요'\n: '춥다' -> '춥' + '어요' = '춥어요' -> '추워요' (exception)\nMost of the exceptions are for easier pronunciation.\n'추워요' is more comfortable and natural to pronounce than '춥어요'.",
            "-",
            "-",
            "conjugate '아요/어요'\n: '오다' -> '오' + '아요' = '오아요' -> '와요'",
            "-",
            "-",
            "You can make negative forms by using '안' before a verb or adjective or '~지 않다' form.\n'안' + '오다' = '안 와요'\n'오다' -> '오' + '지 않다' = '오지 않다'\n\nWhen you form a verb composed of 'N + 하다' into a negative sentence,\nyou can use a 'N + 안 + 하다' form.\n\nex)\n'얘기하다' -> '얘기 안 하다'\n'얘기하다' -> '얘기하지 않다'",
            "-",
            "-"
    };

    private String[] dialog = {
            "한국 날씨가 어때요?",
            "조금 추워요.",
            "눈이 와요?",
            "눈은 별로 안 와요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {2,5,8,12};


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
