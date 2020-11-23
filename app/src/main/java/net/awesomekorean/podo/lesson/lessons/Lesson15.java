package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson15 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_15";
    private String lessonTitle = "ability";
    private String lessonSubTitle = "~(으)ㄹ 수 있어요";

    private String[] wordFront = {"아직", "자막", "이해하다", "괜찮다"};

    private String[] wordBack = {"yet", "subtitles", "understand", "all right / okay"};

    private String[] wordPronunciation = {"-", "-", "-", "[괜찬타]"};

    private String[] sentenceFront = {
            "재미있어요.",
            "이 드라마 재미있어요",
            "그런데",
            "없어요.",
            "자막이 없어요.",
            "아직 자막이 없어요.",
            "어때요?",
            "이해하다",
            "이해할 수 있어요?",
            "괜찮아요.",
            "조금 이해할 수 있어요.",
            "볼 거예요.",
            "두 번 볼 거예요"
    };

    private String[] sentenceBack = {
            "It's fun.",
            "This drama is fun.",
            "However",
            "There isn't.",
            "There's no subtitles.",
            "There's no subtitles yet.",
            "How is it?",
            "understand",
            "Can you understand?",
            "That's OK.",
            "I can understand a little bit.",
            "I'll watch it.",
            "I'll watch it twice."
    };

    private String[] sentenceExplain = {
            "-",
            "-",
            "same meaning with '하지만'",
            "-",
            "-",
            "-",
            "-",
            "-",
            "You can use it to describe what you can do.\nBut if you want to describe what you cannot do, you can say 'V-(으)ㄹ 수 없다'\nYou can also use '못'.\n\nconjugate 'V-(으)ㄹ 수 있다/없다'\n: '이해하다' -> '이해하' + 'ㄹ 수 있다' = '이해할 수 있다'\n: '이해하다' ->' 이해하' + 'ㄹ 수 없다' = '이해할 수 없다'\n\nnegative '못'\n: '이해하다' -> '이해 못 하다'",
            "-",
            "-",
            "Future tense used in this sentence.",
            "'번' is the unit noun for the number of times."
    };

    private String[] dialog = {
            "이 드라마 재미있어요.\n그런데 아직 자막이 없어요.\n어때요?\n이해할 수 있어요?",
            "괜찮아요.\n조금 이해할 수 있어요.\n두 번 볼 거예요."
    };

    private int[] peopleImage = {R.drawable.female_b,R.drawable.male_p};

    private int[] reviewId = {1,5,8,10,12};


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
