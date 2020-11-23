package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class Lesson25 extends LessonInit_Lock implements Lesson, LessonItem, Serializable {

    private String lessonId = "L_25";
    private String lessonTitle = "try";
    private String lessonSubTitle = "~아/어 보다";


    private String[] wordFront = {"알다", "모르다", "쓰다", "가르치다", "선생님", "만들다", "받다"};

    private String[] wordBack = {"know", "don't know", "use", "teach", "teacher", "make", "receive"};

    private String[] wordPronunciation = {"-", "-", "-", "-", "-", "-", "[받따]"};

    private String[] sentenceFront = {
            "알아요?",
            "포도앱 알아요?",
            "아니요. 몰라요.",
            "뭐예요?",
            "그게 뭐예요?",
            "선생님이 만든 앱이에요.",
            "한국어를 가르치는 선생님이 만든 앱이에요.",
            "써 봐요.",
            "한번 써 봐요.",
            "다운 받아 볼게요."
    };

    private String[] sentenceBack = {
            "Do you know?",
            "Do you know the 'podo' app?",
            "No. I don't know.",
            "What is it?",
            "What is that?",
            "It's an app developed by a teacher.",
            "It's an app developed by a teacher who teaches Korean.",
            "Try it.",
            "Try it once.",
            "I'll download it."
    };

    private String[] sentenceExplain = {
            "-",
            "Mobile application usually referred to as '앱' or '어플'",
            "Sometimes students are confused.\n\n'아니요' : no\n'아니에요' : not",
            "-",
            "'그게' = '그것이'",
            "When you want to describe a noun with an adjective or verb, use the '~ (으) ㄴ / 는 / (으) ㄹ' form.\nHowever, it is recommended to learn through the sentences in a practical way rather than memorizing it grammatically because the transformations are very diverse and there are many exceptions.\n\n'만들다' -> '만들' + '은' = '만들은' -> '만든' (irregular)\n\nex)\n'읽다' -> '읽은'\n'먹다' -> '먹은'\n'배우다' -> '배운'",
            "However, it is good to learn the '~ (으) ㄴ / 는 / (으) ㄹ' form that can be changed depending on the tense.\n\npast tense : (으)ㄴ\npresent tense : 는\nfuture tense : (으)ㄹ\n\nex)\n'가르치다' \n-> '가르친' (past tense) : 한국어를 가르친 선생님 (The teacher who taught Korean)\n-> '가르치는' (present tense) : 한국어를 가르치는 선생님 (The teacher  who is teaching Korean)\n-> '가르칠' (future tense) : 한국어를 가르칠 선생님 (The teacher who will teach Korean)",
            "'쓰다' -> '써요' -> '써 보다'",
            "-",
            "Korean usually say '다운로드'(download) as '다운' in a simple way.\nAnd the verb '받다' often can be used with '다운'.\nKorean would rather say '다운받다' a mix of English word and Korean than 'download'.\n\n'보다' -> '보' + 'ㄹ 게요' = '볼게요'"
    };

    private String[] dialog = {
            "포도앱 알아요?",
            "아니요. 몰라요.\n그게 뭐예요?",
            "한국어를 가르치는 선생님이 만든 앱이에요.\n한번 써 봐요.",
            "고마워요.\n다운 받아 볼게요"
    };

    private int[] peopleImage = {R.drawable.male_b,R.drawable.female_p};

    private int[] reviewId = {6,8};


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
