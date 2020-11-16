package net.awesomekorean.podo.lesson.lessons;

import java.io.Serializable;

public class Lesson44 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_44";
    private String lessonTitle = "honorific";
    private String lessonSubTitle = "~(으)시";
    private LessonItem specialLesson = new S_Lesson20();

    private String[] wordFront = {"옷", "입다", "벗다", "바꾸다"};

    private String[] wordBack = {"clothes", "put on", "take off", "change"};

    private String[] wordPronunciation = {"-", "[입따]", "[벋따]", "-"};

    private String[] sentenceFront = {
            "옷을 샀어요.",
            "인터넷으로 옷을 샀어요.",
            "어떠세요?",
            "입어 보셨어요?",
            "그런데 너무 작아요.",
            "빨리 바꾸세요."
    };

    private String[] sentenceBack = {
            "I bought clothes.",
            "I bought clothes online(internet).",
            "How's it?",
            "Have you tried it on?",
            "But it's too small.",
            "Change it quickly."
    };

    private String[] sentenceExplain = {
            "-",
            "(으)로' is used as a meaning of method.\n(Refer to 'more expression - (으)로')\nYou can consider the '인터넷' as a place and say '인터넷에서 옷을 샀어요'.",
            "You can use '(으)시' form to make it honorific expression.\n" +
                    "In the previous lesson, we've learned '~(으)세요' form.  \n" +
                    "At this time, '(으)시' form was already used.\n" +
                    "For example,\n" +
                    "'먹다' -> '먹' + '으시' + '어요' = '먹으시어요' -> '먹으셔요' -> '먹으세요'\n" +
                    "\n" +
                    "It's important to get used to it by seeing a lot of '(으)시' form because it's a bit complicated to conjugate.\n" +
                    "'어떠하다' -> '어떠하' + '세요' = '어떠하세요' -> '어떠세요'",
            "보다' -> '보' + '시' + '었어요' = '보시었어요' -> '보셨어요'",
            "-",
            "바꾸다' -> '바꾸' + '세요' = '바꾸세요'"
    };

    private String[] dialog = {
            "어제 인터넷으로 옷을 샀어요.",
            "어떠세요? 입어 보셨어요?",
            "네, 그런데 너무 작아요.",
            "그럼 빨리 바꾸세요."
    };

    private int[] peopleImage = {12,11};

    private int[] reviewId = {3,5};


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
}
