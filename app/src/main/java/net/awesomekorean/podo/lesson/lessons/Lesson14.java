package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson14 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_14";
    private String lessonTitle = "after";
    private String lessonSubTitle = "~후에";
    private LessonItem specialLesson = new S_Lesson11();

    private String[] wordFront = {"오늘", "저녁", "끝나다", "후", "가족", "드라마", "추천하다"};

    private String[] wordBack = {"today", "evening / dinner", "finish / end", "after", "family", "drama", "recommend"};

    private String[] wordPronunciation = {"-", "-", "[끈나다]", "-", "-", "-", "-"};

    private String[] sentenceFront = {
            "뭐 해요?",
            "저녁에 뭐 해요?",
            "오늘 저녁에 뭐 해요?",
            "끝나다",
            "끝난 후에",
            "일이 끝난 후에",
            "일이 끝난 후에 저녁을 먹어요.",
            "일이 끝난 후에 가족이랑 저녁을 먹어요.",
            "먹다",
            "먹은 후에",
            "저녁을 먹은 후에",
            "저녁을 먹은 후에 드라마를 봐요.",
            "저녁을 먹은 후에 드라마를 볼 거예요.",
            "보다",
            "봐요?",
            "드라마 봐요?",
            "요즘 드라마 봐요?",
            "추천하다",
            "추천해요.",
            "추천해 주세요.",
            "저도 추천해 주세요."
    };

    private String[] sentenceBack = {
            "What do you do?",
            "What do you do at night?",
            "What will you do at night today?",
            "finish",
            "after finishing",
            "after finishing work",
            "I'll have a dinner after finishing work.",
            "I'll have a dinner after finishing work with my family.",
            "eat",
            "after having",
            "after having dinner",
            "I watch a drama after having dinner.",
            "I'll watch a drama after having dinner.",
            "watch",
            "Do you watch?",
            "Do you watch dramas?",
            "Do you watch dramas these days?",
            "recommend",
            "recommend.",
            "Please recommend.",
            "Please recommend me too."
    };

    private String[] sentenceExplain = {
            "-",
            "-",
            "You can also say '뭐 할거예요?' using the future tense.\nBut when you are talking about a certain moment of the future such as 'tonight', 'tomorrow', 'next week', 'next month' or 'next year', you can use the present tense.",
            "-",
            "If the verb doesn't have a Batchim, use 'V-ㄴ 후에' and if it has a Batchim, use 'V-은 후에'.\n'끝나다' -> '끝나' + 'ㄴ 후에' = '끝난 후에'\nYou can also use 'N + 후에' instead.\nSame as 'N + 전에' form, only specific nouns which can be used in 'N + 하다' form(related to the action) can be used as 'N + 후에' form. \n\nex) '운동' + '하다' = '운동하다' (o)\n'운동 한 후에~'\n'운동 후에~'",
            "-",
            "-",
            "-",
            "-",
            "'먹다' -> '먹' + '은 후에' = '먹은 후에'",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-",
            "-",
            "When you ask something, you can use '~아/어 주세요'.\n'추천하다' -> '추천해요' -> '추천해' + '주세요' = '추천해 주세요'",
            "-"
    };

    private String[] dialog = {
            "오늘 저녁에 뭐 해요?",
            "일이 끝난 후에 가족이랑 저녁을 먹어요.\n저녁을 먹은 후에 드라마를 볼 거예요.",
            "요즘 드라마 봐요?\n저도 추천해 주세요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {7,12};


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
