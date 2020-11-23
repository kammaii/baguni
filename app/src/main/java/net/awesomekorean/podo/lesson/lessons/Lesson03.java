package net.awesomekorean.podo.lesson.lessons;

import android.os.Messenger;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson03 extends LessonInit implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_03";
    private String lessonTitle = "possession, existence";
    private String lessonSubTitle = "~있어요?";
    private LessonItem specialLesson = new S_Lesson04();
    private Integer dayCount = 3;

    private String[] wordFront = {"있다", "친구", "얘기하다", "어디", "한국어"};

    private String[] wordBack = {"there is / have", "friend", "talk", "where", "Korean language"};

    private String[] wordPronunciation = {"[읻따]", "-", "-", "-", "[한구거]"};

    private String[] sentenceFront = {
            "있다",
            "있어요?",
            "친구 있어요?",
            "한국 친구 있어요?",
            "네, 있어요",
            "네, 한 명 있어요.",
            "얘기하다",
            "얘기해요?",
            "어디에서 얘기해요?",
            "카카오톡",
            "카카오톡에서",
            "카카오톡에서 얘기해요"
    };

    private String[] sentenceBack = {
            "There is",
            "Is there?",
            "Do you have a friend?",
            "Do you have a Korean friend?",
            "Yes, I have a korean friend.",
            "Yes, I have one.",
            "talk",
            "Do you talk?",
            "Where do you talk?",
            "Kakaotalk",
            "on Kakaotalk",
            "We talk on Kakaotalk."
    };
    private String[] sentenceExplain = {
            "You can say this word when you 'have' something or someone 'exists'.\nIn Korean, singular and plural are not important considered and 'There isn't/aren't' means '없다'.",
            "When you conjugate verbs or adjectives into the form of '아요/어요', if you say it without a tone, it's a statement.\nBut if you say it with a high tone, it becomes a question.\nex) '있어요?'(tone up on '요') : Is there? / '있어요'(no tone) : There is",
            "-",
            "-",
            "yes : '네' / no : '아니요'",
            "There are lots of unit nouns in Korean.\nDon't try to learn all at once.\nJust remember to use '명' or '분'(honorific) for people and '개' for things.",
            "-",
            "-",
            "The words that describe the place should be followed by the place particle '에서'.",
            "Kakaotalk: Most popular Messenger App in Korea.",
            "Since KakaoTalk is used as a meaning of conversation channel(place/where), you have to put '에서'.",
            "-"
    };


    private String[] dialog = {
            "한국 친구 있어요?",
            "네, 한 명 있어요.",
            "어디에서 얘기해요?",
            "카카오톡에서 얘기해요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {3,8};


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
