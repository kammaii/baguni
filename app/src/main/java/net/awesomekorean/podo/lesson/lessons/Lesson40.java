package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson40 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_40";
    private String lessonTitle = "to do";
    private String lessonSubTitle = "~(으)려고";
    private Integer dayCount = 21;

    private String[] wordFront = {"월 / 달", "똑똑하다", "기억하다", "수업"};

    private String[] wordBack = {"month", "smart", "remember", "lesson"};

    private String[] wordPronunciation = {"-", "[똑또카다]", "[기어카다]", "-"};

    private String[] sentenceFront = {
            "언제부터 배웠어요?",
            "한국어를 언제부터 배웠어요?",
            "3개월 배웠어요.",
            "3개월 정도 배웠어요.",
            "3개월 밖에 안 배웠어요?",
            "그런데 이렇게 잘해요?",
            "똑똑한 것 같아요.",
            "정말 똑똑한 것 같아요.",
            "수업 시간에 배운 것",
            "수업 시간에 배운 것을 기억하려고 ",
            "수업 시간에 배운 것을 기억하려고 매일 공부해요."
    };

    private String[] sentenceBack = {
            "Since when did you learn",
            "Since when did you learn Korean?",
            "I've learned it for 3 months.",
            "I've learned it for about 3 months.",
            "You've learned it for only 3 months?",
            "But how come you do it so well like that?",
            "I think you are smart.",
            "I think you are so smart.",
            "What I've learned in the lesson",
            "To remember what I've learned in the lesson",
            "I study every day to remember what I've learned in the lesson."
    };

    private String[] sentenceExplain = {
            "-",
            "-",
            "'월' : comes from Chinese character\n'달' : native Korean\n\nThere are 2 ways to count months.\n'3개월' [삼개월]\n'3달' [세달]\n\nDon't be confused that '3월'[삼월] means 'March'.",
            "If you use '정도' or '쯤' following after the word indicating quantity, it means 'about(approximately)'.",
            "When you want to say 'few', 'little', you can use '~밖에' and have to put negative form after.\n\nex)\n'~밖에 안~'\n'~밖에 못~'\n'~밖에 없다'",
            "You can use '이렇게' to express a big surprise.",
            "-",
            "-",
            "'배우다' -> '배우' + 'ㄴ 것' = '배운 것'",
            "When describing the intention or purpose, you can use '~(으)려고'.\n\n'기억하다' -> '기억하' + '려고' = '기억하려고'",
            "-"
    };

    private String[] dialog = {
            "한국어를 언제부터 배웠어요?",
            "3개월 정도 배웠어요.",
            "와! 3개월 밖에 안 배웠어요?\n그런데 이렇게 잘해요?\n정말 똑똑한 것 같아요.",
            "아니에요.\n수업 시간에 배운 것을\n기억하려고 매일 공부해요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {1,3,10};


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
