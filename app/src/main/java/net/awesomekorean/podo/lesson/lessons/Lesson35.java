package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson35 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_35";
    private String lessonTitle = "if want to";
    private String lessonSubTitle = "~(으)려면";
    private Integer dayCount = 14;


    private String[] wordFront = {"타다", "선물", "화장품", "생일", "자동차/차"};

    private String[] wordBack = {"ride", "gift", "cosmetics", "birthday", "car"};

    private String[] wordPronunciation = {"-", "-", "-", "-", "-"};

    private String[] sentenceFront = {
            "명동에 가다.",
            "명동에 가려면",
            "명동에 가려면 어떻게 해요?",
            "지하철 타다.",
            "지하철 타고 가다.",
            "지하철 타고 갈 수 있어요.",
            "명동에 왜 가요?",
            "내일 친구 생일이에요.",
            "화장품 선물 사고 싶어요.",
            "같이 가요.",
            "제 차 타고 같이 가요."
    };

    private String[] sentenceBack = {
            "Go to Myeong-dong",
            "To go to Myeong-dong",
            "How do I get to Myeong-dong?",
            "Take the subway",
            "Go by subway",
            "You can take the subway.",
            "Why are you going to Myeong-dong?",
            "It's my friend's birthday tomorrow.",
            "I want to buy a cosmetic for a gift.",
            "Let's go together.",
            "Let's go together by my car."
    };

    private String[] sentenceExplain = {
            "'명동' is a famous place for shopping in Seoul. In particular, there are many cosmetic shops.",
            "When you explain/ask a way(method), you can use '(으)려면'.\n\n'가다' -> '가' + '려면' = '가려면'",
            "-",
            "-",
            "'타다' 그리고 '가다' = '타고 가다'",
            "'가다' -> '가' + 'ㄹ 수 있다' = '갈 수 있다'",
            "-",
            "-",
            "-",
            "-",
            "-"
    };

    private String[] dialog = {
            "명동에 가려면 어떻게 해요?",
            "지하철 타고 갈 수 있어요.\n명동에 왜 가요?",
            "내일 친구 생일이에요.\n화장품 선물 사고 싶어요.",
            "그래요? 제 차 타고 같이 가요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {2,7};


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
