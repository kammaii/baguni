package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson19 extends LessonInit implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_19";
    private String lessonTitle = "others";
    private String lessonSubTitle = "고맙습니다";
    private LessonItem specialLesson = new S_Lesson01();
    private Integer dayCount = 2;

    private String[] wordFront = {"안녕히 주무세요", "고맙습니다", "죄송합니다", "잘 먹겠습니다", "잘 먹었습니다", "어서오세요"};

    private String[] wordBack = {"good night", "thank you", "I'm sorry", "thank you (before having a meal)", "thank you for the meal", "welcome"};

    private String[] wordPronunciation = {"-", "[고맙씀니다]", "[죄송함니다]", "[잘 먹겓씀니다]", "[잘 머걷씀니다]", "-"};

    private String[] sentenceFront = {
            "안녕히 주무세요.",
            "고맙습니다 / 감사합니다",
            "죄송합니다 / 미안합니다",
            "잘 먹겠습니다",
            "잘 먹었습니다",
            "어서오세요"
    };

    private String[] sentenceBack = {
            "good night",
            "thank you",
            "I'm sorry",
            "Thank you for the meal",
            "I had a good meal.",
            "Welcome"
    };

    private String[] sentenceExplain = {
            "To close friends : '잘 자~'",
            "You can use whichever you want. It is 100% the same.\nTo close friends : '고마워~'",
            "You should say '죄송합니다' to someone older than you or with a higher position than you.\nTo close friends : '미안~'",
            "It cannot be translated directly into English. In a literal translation, it means 'I will eat well' but It's actually a greeting for the person who provided/prepared the meal for you.\nTo close friends : '잘 먹을게~'",
            "To close friends : '잘 먹었어~'",
            "Usually, this is the first greeting you will hear when you enter a restaurant or a store."
    };


    private String[] dialog = {
            "안녕히 주무세요.",
            "고맙습니다 / 감사합니다",
            "죄송합니다 / 미안합니다",
            "잘 먹겠습니다",
            "잘 먹었습니다",
            "어서오세요"
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.male_p};

    private int[] reviewId = {0,3,4,5};


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

    @Override
    public Integer getDayCount() {
        return dayCount;
    }
}
