package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson04 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_04";
    private String lessonTitle = "shopping2";
    private String lessonSubTitle = "쇼핑 하기2";

    private String[] dialog = {
            "어서 오세요. ",
            "티셔츠(T-shirt)는 어디에 있어요?",
            "티셔츠는 이쪽이에요.",
            "고맙습니다.",
            "천천히 보세요.",
            "이거 좀 큰 사이즈(size) 있어요?",
            "네, 여기 있어요.",
            "입어 볼 수 있어요?",
            "네, 저쪽에서 입어보세요.\n(옷을 입은 후) 어떠세요?",
            "다른 것도 볼게요.",
            "이거도 입어보세요.",
            "이거 예쁘네요. 얼마예요?",
            "50,000원이에요.",
            "좀 싸게 해주면 안돼요?",
            "알겠어요. 한국어 잘하니까 싸게 해 줄게요. 45,000원만 주세요.",
            "고맙습니다!"
    };

    private String[] dialogEng = {
            "Welcome.",
            "Where is a T-shirt?",
            "A T-shirt is this way.",
            "Thank you.",
            "Take your time.",
            "Do you have this a little larger size?",
            "Yes, here it is.",
            "Can I try this on?",
            "Yes, try on it over there.\n(after wearing) How is it?",
            "I want to see another one.",
            "Try on this as well.",
            "This is pretty. How much?",
            "It is 50,000 won.",
            "Can you give me a discount?",
            "OK. I’ll give you cheaply because you are good at Korean. Give me 45,000 won only.",
            "Thank you!"
    };

    private int[] peopleImage = {R.drawable.clothing_store_b, R.drawable.male_p};

    @Override
    public String getLessonSubTitle() {
        return lessonSubTitle;
    }

    @Override
    public String getLessonId() {
        return lessonId;
    }

    @Override
    public String[] getDialog() {
        return dialog;
    }

    @Override
    public String[] getDialogEng() {
        return dialogEng;
    }

    @Override
    public int[] getPeopleImage() {
        return peopleImage;
    }



    // 레슨어뎁터 아이템

    @Override
    public String getLessonTitle() {
        return lessonTitle;
    }

}
