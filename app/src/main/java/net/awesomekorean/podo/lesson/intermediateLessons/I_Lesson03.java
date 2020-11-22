package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson03 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_03";
    private String lessonTitle = "shopping1";
    private String lessonSubTitle = "쇼핑 하기1";
    private Integer dayCount = 27;

    private String[] dialog = {
            "어서 오세요. 뭐 찾으세요?",
            "화장품을 찾고 있어요.",
            "이쪽으로 오세요. 이게 요즘 인기가 많아요.",
            "다른 거는 없어요?",
            "음… 이거도 좋아요.",
            "좋네요. 얼마예요?",
            "100,000원이에요. 드릴까요?",
            "아니요. 좀 비싼 것 같아요.",
            "그럼 이건 어때요? 사이즈(size)는 조금 작은데 가격은 싸요.",
            "좋네요. 이거 주세요.",
            "네. 다른 거는 필요없어요?",
            "마스크팩도 필요해요.",
            "마스크팩은 이쪽에 있어요.",
            "네, 이거로 할게요.",
            "알겠습니다.",
            "카드로 계산할게요.",
            "네. 감사합니다. 다음에 또 오세요."
    };

    private String[] dialogEng = {
            "welcome. What are you looking for?",
            "I'm looking for cosmetics.",
            "Come over here. This is very popular these days.",
            "Anything else?",
            "Well… This one is also good.",
            "Good. How much is it?",
            "It's 100,000 won. Would you like it?",
            "no. I think it's a little expensive.",
            "Well, what about this one? The size is a little small, but the price is cheap.",
            "Good. please give me this.",
            "Ok. Would you like anything else?",
            "I also need a mask pack.",
            "The mask pack is on this side.",
            "Ok, I will buy this.",
            "Okay.",
            "I’ll pay by credit card.",
            "Ok. Thank you. Come again next time."
    };

    private int[] peopleImage = {R.drawable.cosmetic_shop_b, R.drawable.male_p};

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

    @Override
    public Integer getDayCount() {
        return dayCount;
    }
}
