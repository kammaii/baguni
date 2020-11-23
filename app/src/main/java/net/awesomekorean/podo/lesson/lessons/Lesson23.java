package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson23 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_23";
    private String lessonTitle = "if, when";
    private String lessonSubTitle = "~(으)면";

    private String[] wordFront = {"나중에", "돈을 벌다", "외국", "모든", "문화"};

    private String[] wordBack = {"later", "make money", "foreign country", "every", "culture"};

    private String[] wordPronunciation = {"-", "[도늘 벌다]", "-", "-", "-"};

    private String[] sentenceFront = {
            "뭐 하고 싶어요?",
            "돈을 벌면 뭐 하고 싶어요?",
            "나중에 돈을 많이 벌면 뭐 하고 싶어요?",
            "가고 싶어요.",
            "외국 여행을 가고 싶어요.",
            "외국 여행을 많이 가고 싶어요.",
            "문화를 배우고 싶어요.",
            "모든 나라의 문화를 다 배우고 싶어요.",
            "그렇군요. 대단해요!"
    };

    private String[] sentenceBack = {
            "What do you want to do?",
            "What do you want to do if you make money?",
            "What do you want to do if you make a lot of money later?",
            "I want to go.",
            "I want to take a trip to abroad",
            "I want to take a trip to abroad a lot",
            "I want to learn culture.",
            "I want to learn country cultures",
            "I See. Great!"
    };

    private String[] sentenceExplain = {
            "'하다' -> '하' + '고 싶다' = '하고 싶다'",
            "It is used as a meaning of 'if' or 'when'.\n\nex)\n'돈을 벌다' -> '돈을 벌' + '면' = '돈을 벌면'\n'피곤하다' -> '피곤하' + '면' = '피곤하면'\n'먹다' -> '먹' + '으면' = '먹으면'",
            "-",
            "'가다' -> '가' + '고 싶다' = '가고 싶다'",
            "-",
            "-",
            "'배우다' -> '배우' + '고 싶다' = '배우고 싶다'",
            "Many students are confused '모든' and '다' but it is not difficult.\n\n'모든' + N\n'다' + A/V",
            "-"
    };

    private String[] dialog = {
            "나중에 돈을 많이 벌면 뭐 하고 싶어요?",
            "외국 여행을 많이 가고 싶어요.\n모든 나라의 문화를 다 배우고 싶어요.",
            "그렇군요. 대단해요!"
    };

    private int[] peopleImage = {R.drawable.female_b,R.drawable.male_p};

    private int[] reviewId = {2,5,7};


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
