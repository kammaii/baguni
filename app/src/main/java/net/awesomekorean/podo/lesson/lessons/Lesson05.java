package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson05 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_05";
    private String lessonTitle = "future";
    private String lessonSubTitle = "~(으)ㄹ 거예요";

    private String[] wordFront = {"내일", "식당", "주말", "재미있다", "영화"};

    private String[] wordBack = {"tomorrow", "restaurant", "weekend", "fun / interesting", "movie"};

    private String[] wordPronunciation = {"-", "[식땅]", "-", "[재미읻따]", "-"};

    private String[] sentenceFront = {
            "하다",
            "할 거예요?",
            "뭐 할 거예요?",
            "내일 뭐 할 거예요?",
            "가다",
            "갈 거예요.",
            "식당에 갈 거예요.",
            "한국 식당에 갈 거예요.",
            "친구랑 한국 식당에 갈 거예요.",
            "주말에는요?",
            "보다",
            "볼 거예요.",
            "영화를 볼 거예요.",
            "재미있는 영화를 볼 거예요."
    };

    private String[] sentenceBack = {
            "do",
            "Will you do?",
            "What will you do?",
            "What will you do tomorrow.",
            "Go",
            "I will go.",
            "I will go to a restaurant.",
            "I will go to a Korean restaurant.",
            "I will go to a Korean restaurant with my friend.",
            "What about on the weekend?",
            "see / watch / look",
            "I will watch.",
            "I will watch a movie.",
            "I will watch a fun movie."
    };

    private String[] sentenceExplain = {
            "-",
            "When you say future tense, you can conjugate 'ㄹ 거예요/을 거예요' form.\nIf there is no Batchim, add 'ㄹ 거예요', if there is a Batchim, add '을 거예요'.\n'하다' -> '하' + 'ㄹ 거예요' = '할 거예요'",
            "-",
            "-",
            "-",
            "conjugate 'ㄹ 거예요/을 거예요'\n: '가다' -> '가' + 'ㄹ 거예요' = '갈 거예요'",
            "If you use verbs related to movement ('가다', '오다', '들어가다' etc ...), you have to add '에' following after the destination(noun).\nBut you can omit '에' in the spoken language.",
            "-",
            "We can say ‘랑/이랑’ for the conversational language.",
            "-",
            "-",
            "conjugate 'ㄹ 거예요/을 거예요'\n: '보다' -> '보' + 'ㄹ 거예요' = '볼 거예요'",
            "Object particle is used in this phrase.\nHowever, you can omit object particles in a conversational style.\n'영화를 볼 거예요' -> '영화 볼 거예요'",
            "-"
    };

    private String[] dialog = {
            "내일 뭐 할 거예요?",
            "친구랑 한국 식당에 갈 거예요.",
            "주말에는요?",
            "재미있는 영화를 볼 거예요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {3,8,13};


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
