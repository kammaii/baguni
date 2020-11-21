package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson28 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_28";
    private String lessonTitle = "while";
    private String lessonSubTitle = "~(으)면서";

    private String[] wordFront = {"다이어트", "시작하다", "매일", "운동하다", "혼자", "재미없다"};

    private String[] wordBack = {"(be on a)diet", "start", "everyday", "exercise", "alone", "not fun"};

    private String[] wordPronunciation = {"-", "[시자카다]", "-", "-", "-", "[재미업따]"};

    private String[] sentenceFront = {
            "시작했어요.",
            "다이어트를 시작했어요.",
            "요즘 다이어트를 시작했어요.",
            "운동해요.",
            "집에서 운동해요.",
            "매일 집에서 운동해요.",
            "혼자 운동해요?",
            "재미없지 않아요?",
            "TV를 보다.",
            "TV를 보면서 운동해요."
    };

    private String[] sentenceBack = {
            "I started.",
            "I started a diet.",
            "I just started a diet.",
            "I work out.",
            "I work out at home.",
            "I work out at home everyday.",
            "Do you work out alone?",
            "It's not fun, isn't it?",
            "Watch TV.",
            "I watch TV while I am working out."
    };

    private String[] sentenceExplain = {
            "'시작해요' -> '시작했어요' (past tense)",
            "You can say '다이어트' for losing weight.",
            "-",
            "-",
            "-",
            "-",
            "-",
            "You may got confused because this sentence used negative expression twice.\nWhen you want to ask if the other person has the same feelings/thoughts with you, you can ask '~지 않아요?'.\n'재미없다' -> '재미없' + '지 않아요?' = '재미없지 않아요?'\n\nIf there's no question mark like '~지 않아요.' it is just a negative sentence.",
            "-",
            "When you are doing two activities at the same time, use the '~(으)면서' form.\n\n'TV를 보다' + '운동하다' -> 'TV를 보면서 운동하다'\n'밥을 먹다' + 'TV를 보다' -> 밥을 먹으면서 TV를 보다'"
    };

    private String[] dialog = {
            "요즘 다이어트를 시작했어요.\n매일 집에서 운동해요.",
            "혼자 운동해요?\n재미없지 않아요?",
            "네, 그래서 TV를 보면서 운동해요."
    };

    private int[] peopleImage = {3,4};

    private int[] reviewId = {2,5,6,7,9};


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
