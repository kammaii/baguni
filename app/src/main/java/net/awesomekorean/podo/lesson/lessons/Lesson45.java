package net.awesomekorean.podo.lesson.lessons;

import java.io.Serializable;

public class Lesson45 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_45";
    private String lessonTitle = "formal";
    private String lessonSubTitle = "~(스)ㅂ니다";

    private String[] wordFront = {"문제", "다시", "확인하다", "전화하다"};

    private String[] wordBack = {"problem", "again", "confirm", "make a phone call"};

    private String[] wordPronunciation = {"-", "-", "[화긴]", "-"};

    private String[] sentenceFront = {
            "여보세요?",
            "바꾸고 싶어요.",
            "옷을 바꾸고 싶어요.",
            "문제가 있습니까?",
            "옷에 어떤 문제가 있습니까?",
            "사이즈가 달라요.",
            "보내드릴까요?",
            "옷을 다시 보내드릴까요?",
            "전화드리겠습니다.",
            "다시 전화드리겠습니다.",
            "확인해보고 다시 전화드리겠습니다.",
    };

    private String[] sentenceBack = {
            "Hello?",
            "I want to change.",
            "I want to change clothes.",
            "Is there a problem?",
            "Is there something wrong with your clothes?",
            "The size is different.",
            "Can I send you?",
            "Would you mind if I send you the clothes again?",
            "I'll call you.",
            "I'll call you again.",
            "I will check and call again.",
    };

    private String[] sentenceExplain = {
            "When making a phone call, you can call the other person regardless of their age.",
            "-",
            "-",
            "(스)ㅂ니다' form is used in situations or relationships that require formality, and when asking a question, you can use '(스)ㅂ니까?'.\n" +
                    "'문제가 있다' -> '문제가 있' + '습니까?' = '문제가 있습니까?'",
            "-",
            "다르다' -> '다르' + '아요' -> '다르아요' -> '달라요' (irregular)",
            "드리다' -> '드리' + 'ㄹ까요?' = '드릴까요?'",
            "Already we have learned the word '또' in the meaning of 'again'.\n" +
                    "- '다음에 또 만나요' \n" +
                    "- '다음에 다시 만나요'\n" +
                    "It can be used with the same meaning as the two sentences above, but there are cases where it has different meanings.\n" +
                    "\n" +
                    "There are differences as follows.\n" +
                    "- 또 : repeat what I did now\n" +
                    "- 다시 : repeat what I did now (by using another method or fixing it). Or, continue what I stopped.\n" +
                    "\n" +
                    "For example, let's consider this sentence.\n" +
                    "- '옷을 또 보내드릴까요?' :  Shall I send you the clothes again?\n" +
                    "- '옷을 다시 보내드릴까요?' : Shall I send you the (different) clothes again?\n" +
                    "\n" +
                    "It may be a little difficult, it might be a good idea to think about their exact meaning when you see those words later.",
            "드리겠다' -> '드리겠' + '습니다' = '드리겠습니다'",
            "-",
            "-",
    };

    private String[] dialog = {
            "여보세요? 옷을 바꾸고 싶어요.",
            "안녕하세요? 옷에 어떤 문제가 있습니까?",
            "네, 사이즈가 달라요.",
            "죄송합니다. 옷을 다시 보내드릴까요?",
            "네.",
            "알겠습니다. 확인해보고 다시 전화드리겠습니다."
    };

    private int[] peopleImage = {2,1};

    private int[] reviewId = {2,5,7,9};


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
