package net.awesomekorean.podo.lesson.lessons;

import java.io.Serializable;

public class Lesson43 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_43";
    private String lessonTitle = "asking2";
    private String lessonSubTitle = "~(으)ㄹ까요?";
    private Integer dayCount = 23;
    private LessonItem specialLesson = new S_Lesson19();

    private String[] wordFront = {"이제", "배부르다", "인기가 많다", "가격", "앉다"};

    private String[] wordBack = {"now", "full", "popular", "price", "sit"};

    private String[] wordPronunciation = {"-", "-", "[인끼가 만타]", "-", "[안따]"};

    private String[] sentenceFront = {
            "이제 배불러요.",
            "인기가 많은 것 같아요.",
            "가격도 싸고 맛있어요.",
            "다음에 또 와요.",
            "이제 나갈까요?",
            "앉아있고 싶어요.",
            "조금만 더 앉아있고 싶어요.",
            "너무 배불러서 조금만 더 앉아있고 싶어요."
    };

    private String[] sentenceBack = {
            "I'm full now.",
            "I think it is very popular.",
            "The price is cheap and delicious.",
            "Let's come again next time.",
            "Shall we go out now?",
            "I want to sit down.",
            "I want to sit a little longer.",
            "I'm so full so I want to sit a little longer."
    };

    private String[] sentenceExplain = {
            "Both '지금' and '이제' have the same meaning of 'now'.\nBut unlike '지금', which simply expresses time,\n'이제' gives the feeling of a change of atmosphere.",
            "'인기가 많다' -> '인기가 많' + '은 것 같다' = '인기가 많은 것 같다'",
            "-",
            "-",
            "'(으)ㄹ까요?' and '(으)ㄹ래요?' is very similar.\nTherefore, this sentence can be changed into '이제 나갈래요?'",
            "'아/어 있다' form indicates that the status persists after an action has ended.\n'앉다' -> '앉' + '아 있다' = '앉아 있다'\n'앉아 있다' -> '앉아 있' + '고 싶다' = '앉아있고 싶다'",
            "-",
            "'배부르다' -> '배불러요' (irregular)"
    };

    private String[] dialog = {
            "아, 이제 배불러요.",
            "이 식당, 인기가 많은 것 같아요.",
            "네, 가격도 싸고 맛있어요.",
            "다음에 또 와요. 이제 나갈까요?",
            "아니요. 너무 배불러서 조금만 더 앉아있고 싶어요."
    };

    private int[] peopleImage = {9,10};

    private int[] reviewId = {0,1,2,3,4,6};


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

    @Override
    public LessonItem getSLesson() {
        return specialLesson;
    }
}
