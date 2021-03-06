package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson01 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_01";
    private String lessonTitle = "order";
    private String lessonSubTitle = "음식 주문";
    private Integer dayCount = 26;

    private String[] dialog = {
            "어서 오세요. 몇 분이에요?",
            "두 명이에요.",
            "이쪽으로 오세요. 여기에 앉으세요.",
            "고맙습니다. 메뉴(menu) 좀 주세요.",
            "네, 여기 있습니다.",
            "추천 메뉴 있어요?",
            "네, 이거랑 이거 맛있어요.",
            "잠시 후에 주문할게요.",
            "네. 천천히 보세요.\n(잠시 후)",
            "여기요.",
            "주문하시겠어요?",
            "네, 이거랑 이거 주세요.",
            "네, 마실 거는요?",
            "물 주세요.",
            "네, 더 필요한 거 없어요?",
            "아! 너무 맵지 않게 해주세요.",
            "알겠습니다. (잠시 후)",
            "배고파요.",
            "음식 나왔습니다. 맛있게 드세요.",
            "잘 먹겠습니다.",
            "(다 먹은 후)\n맛있게 드셨어요?",
            "네, 잘 먹었습니다.",
            "디저트(dessert) 드릴까요?",
            "뭐 있어요?",
            "커피랑 아이스크림 있어요.",
            "커피 주세요.",
            "네.",
            "얼마예요?",
            "20,000원입니다.",
            "여기요.",
            "감사합니다. 다음에 또 오세요.",
            "네, 잘 먹었습니다."
    };

    private String[] dialogEng = {
            "Welcome. How many people?",
            "Two.",
            "This way. Please take a seat here.",
            "Thank you. menu, please.",
            "Yes, here it is.",
            "Do you have a recommendation?",
            "Yes, this and this are delicious.",
            "I'll order in a minute.",
            "Yes, take your time.\n(After a while)",
            "Excuse me.",
            "Are you ready to order?",
            "Yes, this and this, please.",
            "Ok, anything to drink?",
            "Water, please.",
            "Ok, would you like anything else?",
            "Ah! Not too spicy, please.",
            "I see. (After a while)",
            "I'm hungry.",
            "Here it is. Enjoy your meal.",
            "Thank you.",
            "(After eating)\nDid you enjoy the meal?",
            "Yes, thank you for the meal.",
            "Would you like something for dessert?",
            "What do you have?",
            "Coffee and ice cream.",
            "Coffee, please.",
            "Yes.",
            "How much is it?",
            "It is 20,000 won.",
            "Here you go.",
            "Thank you. Come again next time.",
            "Yes, thank you for the meal."
    };

    private int[] peopleImage = {R.drawable.waiter_b, R.drawable.female_p};

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
