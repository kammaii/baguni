package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson02 extends LessonInit implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_02";
    private String lessonTitle = "how much";
    private String lessonSubTitle = "얼마예요?";
    private boolean isActive = true;

    private String[] wordFront = {"이거", "저거", "얼마", "세일", "그래서"};

    private String[] wordBack = {"this one", "that one", "how much", "discount", "so / therefore"};

    private String[] wordPronunciation = {"-", "-", "-", "[쎄일]", "-"};

    private String[] sentenceFront = {
            "얼마",
            "얼마예요?",
            "이거 얼마예요?",
            "10,000(만)원이에요.",
            "저거",
            "저거는요?",
            "세일",
            "세일이에요.",
            "50% 세일이에요.",
            "저거는 50% 세일이에요.",
            "5,000(오천)원이에요.",
            "그래서 5,000(오천)원이에요."
    };

    private String[] sentenceBack = {
            "how much",
            "How much is it?",
            "How much is this?",
            "It’s 10,000 won.",
            "that one",
            "What about that one?",
            "sale",
            "It’s on sale.",
            "It’s 50% off.",
            "That’s 50% off.",
            "It’s 5,000 won.",
            "So, it’s 5,000 won."
    };

    private String[] sentenceExplain = {
            "-",
            "-",
            "'거' means 'thing', and is often used in spoken language. Formally in a written sentence, it's better to use ‘것’.\n'이거' = '이것'",
            "-",
            "'저거' = '저것'",
            "This is a simple(short) phrase for '저거는 얼마예요?'",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-"
    };

    private String[] dialog = {
            "이거 얼마예요?",
            "10,000(만)원이에요.",
            "저거는요?",
            "저거는 50% 세일이에요.\n 그래서 5,000(오천)원이에요."
    };

    private int[] peopleImage = {R.drawable.female_b,R.drawable.male_p};

    private int[] reviewId = {2};


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

