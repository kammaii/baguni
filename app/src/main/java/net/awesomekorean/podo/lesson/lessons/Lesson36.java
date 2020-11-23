package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson36 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_36";
    private String lessonTitle = "don't";
    private String lessonSubTitle = "~지 마세요";

    private String[] wordFront = {"커피", "졸리다", "새벽", "중독", "주문하다"};

    private String[] wordBack = {"coffee", "sleepy", "dawn", "addicted", "order"};

    private String[] wordPronunciation = {"-", "-", "-", "-", "-"};

    private String[] sentenceFront = {
            "커피 주문했어요?",
            "또 커피 주문했어요?",
            "잘 잤어요?",
            "잘 못 잤어요?",
            "어제 잘 못 잤어요?",
            "SNS 했어요.",
            "새벽까지 SNS 했어요.",
            "SNS 중독이에요.",
            "SNS 하지 마세요.",
            "자기 전에 SNS 하지 마세요."
    };

    private String[] sentenceBack = {
            "Did you order coffee?",
            "Did you order coffee again?",
            "Did you sleep well?",
            "Didn't you sleep well?",
            "Didn't you sleep well yesterday?",
            "I was on Instagram.",
            "I was on Instagram until dawn.",
            "It's social network addiction.",
            "You should stop being on Instagram.",
            "You should stop being on Instagram before going to bed."
    };

    private String[] sentenceExplain = {
            "-",
            "-",
            "-",
            "-",
            "Caution!\n잘못하다 : do wrong\n잘 못 하다 : do not well\n\nex)\n- 죄송해요. 제가 잘못했어요.\n- 저는 컴퓨터를 잘 못 해요.",
            "-",
            "-",
            "-",
            "When you want to strongly ban something, use the '~지 마세요' form.",
            "-",
    };

    private String[] dialog = {
            "또 커피 주문했어요?",
            "네, 너무 졸려요.",
            "어제 잘 못 잤어요?",
            "네, 새벽까지 SNS 했어요.",
            "SNS 중독이에요.\n자기 전에 SNS 하지 마세요."
    };

    private int[] peopleImage = {R.drawable.female_b,R.drawable.male_p};

    private int[] reviewId = {1,4};


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
