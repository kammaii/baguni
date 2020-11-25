package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson45 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_45";
    private String lessonTitle = "formal";
    private String lessonSubTitle = "~(스)ㅂ니다";
    private Integer dayCount = 24;

    private String[] wordFront = {"문제", "다시", "확인하다", "전화하다"};

    private String[] wordBack = {"problem", "again", "check", "call"};

    private String[] wordPronunciation = {"-", "-", "[화긴하다]", "-"};

    private String[] sentenceFront = {
            "여보세요?",
            "바꾸고 싶어요.",
            "옷을 바꾸고 싶어요.",
            "문제가 있습니까?",
            "옷에 어떤 문제가 있습니까?",
            "사이즈(Size)가 달라요.",
            "보내드릴까요?",
            "옷을 다시 보내드릴까요?",
            "전화드리겠습니다.",
            "다시 전화드리겠습니다.",
            "확인해보고 다시 전화드리겠습니다.",
    };

    private String[] sentenceBack = {
            "Hello?",
            "I want to change.",
            "I want to change the clothes.",
            "Is there a problem?",
            "Is there something wrong with your clothes?",
            "The size is different.",
            "Can I send it to you?",
            "Would you mind if I send you the clothes again?",
            "I'll call you.",
            "I'll call you again.",
            "I will check and call again.",
    };

    private String[] sentenceExplain = {
            "When you call to someone, you can say this word regardless of the age of the person who pick up the phone.",
            "-",
            "-",
            "'(스)ㅂ니다' form is used in situations or between relationships that requires the formality, and if it's a question, you can use '(스)ㅂ니까?'.\n'문제가 있다' -> '문제가 있' + '습니까?' = '문제가 있습니까?'",
            "-",
            "'다르다' -> '다르' + '아요' -> '다르아요' -> '달라요' (irregular)",
            "'드리다' -> '드리' + 'ㄹ까요?' = '드릴까요?'",
            "We've already learned the word '또' in the meaning of 'again'.\n- '다음에 또 만나요' \n- '다음에 다시 만나요'\n'또' and '다시' can be used as the same meaning like above 2 example sentences, but depending on the context, these 2 words could indicate a different meaning.\n\nLet's take a look at the difference as below.\n- 또 : Simply repeat the former action\n- 다시 : Repeat the former action with a revision or a change of the way. Or, it could also mean 'resume'.\n\nFor example,\n- '옷을 또(하나 더) 보내드릴까요?' :  Shall I send you the(one more) clothes again?\n- '옷을 다시 보내드릴까요?' : Shall I re-send you the clothes?\n\nIt might be a little difficult, but think about their exact meaning when you see those words later.",
            "'드리겠다' -> '드리겠' + '습니다' = '드리겠습니다'",
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

    private int[] peopleImage = {R.drawable.female_b,R.drawable.male_p};

    private int[] reviewId = {7,9};


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
