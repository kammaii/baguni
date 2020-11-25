package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson00 extends LessonInit implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_00";
    private String lessonTitle = "greetings";
    private String lessonSubTitle = "안녕하세요?";
    private boolean isActive = true;

    private String[] wordFront = {"안녕하세요", "다음", "또", "보다", "가다"};

    private String[] wordBack = {"Hello", "next", "again", "see / watch / look", "go"};

    private String[] wordPronunciation = {"-", "-", "-", "-", "-"};

    private String[] sentenceFront = {
            "안녕하세요? / 안녕?",
            "반가워요",
            "오랜만이에요",
            "잘 지냈어요?",
            "다음에 또 봐요.",
            "안녕히 가세요\n/ 안녕히 계세요"
    };

    private String[] sentenceBack = {
            "Hello / Hi",
            "Nice to meet you",
            "Long time no see",
            "Have you been doing well?\nHow have you been doing?",
            "See you again",
            "Good bye / Bye"
    };

    private String[] sentenceExplain = {
            "No matter if it's morning, afternoon or evening, we say hello.\nYou can just say '안녕' to your close friends.(only if he/she is same age as you or younger than you)",
            "Korean use this word to someone  who I just meet for the first time or who that I haven't seen a while.",
            "-",
            "A Usual greeting to check if someone has been doing well.",
            "-",
            "'가세요' is derived from 'to go' and '계세요' is derived from 'to stay'.\nWhen you say goodbye to someone, if he/she's the one who leave(go), you say '안녕히 가세요' but if he/she's the one who stay in the same place while you are leaving, you say '안녕히 계세요'.\nIf they are close friends or younger than you, you can simply say '안녕'."
    };

    private String[] dialog = {
            "안녕하세요?",
            "반가워요.",
            "오랜만이에요.",
            "잘 지냈어요?",
            "다음에 또 봐요.",
            "안녕히 가세요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {};



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
    public boolean getIsActive() {
        return isActive;
    }
}
