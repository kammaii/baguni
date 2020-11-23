package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson33 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_33";
    private String lessonTitle = "should";
    private String lessonSubTitle = "~아/어야 돼요/해요";
    private LessonItem specialLesson = new S_Lesson17();

    private String[] wordFront = {"새", "듣다", "보내다", "빨리"};

    private String[] wordBack = {"new", "listen", "send", "quickly"};

    private String[] wordPronunciation = {"-", "[듣따]", "-", "-"};

    private String[] sentenceFront = {
            "들어 보다",
            "들어 봤어요?",
            "새 노래 들어 봤어요?",
            "BTS 새 노래 들어 봤어요?",
            "아직이요.",
            "어때요?",
            "정말 좋아요.",
            "꼭 들어 봐야 돼요.",
            "보내 줄게요.",
            "유튜브 링크 보내 줄게요.",
            "고마워요.",
            "들어 볼게요.",
            "지금 들어볼게요.",
            "지금 빨리 들어볼게요."
    };

    private String[] sentenceBack = {
            "Listen.",
            "Have you listened to?",
            "Have you listened to the new song?",
            "Have you listened to the BTS new song?",
            "Not yet.",
            "How is it?",
            "Really good.",
            "You should listen it.",
            "I'll send it.",
            "I will send you the YouTube link.",
            "Thank you.",
            "I'll listen.",
            "I'll listen now.",
            "I'll quickly listen it now."
    };

    private String[] sentenceExplain = {
            "When you describe a try, you can use '아/어 보다' form.\n\n'듣다' -> '들어요' \n'들어' + '보다' -> '들어 보다'",
            "If you use the '아/어 보다' as a past tense, it means 'experience'.\nTherefore, you can also use '아/어 본 적 있다' as a same meaning of '아/어 봤다'.\n\n'들어 봤어요?' = '들어 본 적 있어요?'",
            "-",
            "-",
            "-",
            "-",
            "-",
            "'들어 보다' -> '들어 봐요'\n'들어 봐' + '야 돼요' = '들어 봐야 돼요'\n\nWhen you say 'have to do something', use '~아/어야 돼요/해요' form.\n'들어 봐야 돼요' = '들어 봐야 해요'",
            "-",
            "-",
            "-",
            "'들어 보다' -> '들어 보' + 'ㄹ게요' = '들어 볼게요'",
            "Use the '~(으)ㄹ게요' form when you promise(or will try) something.",
            "-"
    };

    private String[] dialog = {
            "BTS 새 노래 들어 봤어요?",
            "아직이요. 어때요?",
            "정말 좋아요.\n꼭 들어 봐야 돼요.\n제가 유튜브 링크 보내 줄게요.",
            "고마워요.\n지금 빨리 들어 볼게요."
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {3,7,9,13};


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
