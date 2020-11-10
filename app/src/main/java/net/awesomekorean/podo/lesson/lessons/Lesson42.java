package net.awesomekorean.podo.lesson.lessons;

import java.io.Serializable;

public class Lesson42 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_42";
    private String lessonTitle = "asking1";
    private String lessonSubTitle = "~(으)ㄹ래요?";

    private String[] wordFront = {"배고프다", "갑자기", "맵다", "다르다"};

    private String[] wordBack = {"hungry", "suddenly", "spicy", "different"};

    private String[] wordPronunciation = {"-", "[갑짜기]", "[맵따]", "-"};

    private String[] sentenceFront = {
            "먹을래요?",
            "뭐 좀 먹을래요?",
            "매운 음식이 먹고 싶어요.",
            "갑자기 매운 음식이 먹고 싶어요.",
            "저 식당으로 갈래요?",
            "저 식당은 맛없어요.",
            "다른 곳으로 가요."
    };

    private String[] sentenceBack = {
            "Do you want to eat?",
            "Do you want to eat something?",
            "I want to eat spicy food.",
            "Suddenly I want to eat spicy food.",
            "Would you like to go to that restaurant?",
            "That restaurant is not tasty.",
            "Let's go other restaurant."
    };

    private String[] sentenceExplain = {
            "You can ask your close friend for the opinions or intentions with '(으)ㄹ래요?' form.\n'먹다' -> '먹' + '을래요'\nThe answer is the same.\n\nex)\n'먹을래요?'\n'네, 먹을래요.'",
            "-",
            "맵다' -> '매워요' -> '매운'",
            "-",
            "가다' -> '가' + 'ㄹ래요?' = '갈래요?'",
            "-",
            "다르다' means 'different' but \n'다른' can also be used not only 'different' but also 'other'.\n\n'아/어요' form is '달라요' (irregular)"
    };

    private String[] dialog = {
            "뭐 좀 먹을래요?",
            "배고파요?",
            "네, 갑자기 매운 음식이 먹고 싶어요.",
            "그래요. 저 식당으로 갈래요?",
            "아니요. 저 식당은 맛없어요. 다른 곳으로 가요."
    };

    private int[] peopleImage = {7,8};

    private int[] reviewId = {1,2,4,6};


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
