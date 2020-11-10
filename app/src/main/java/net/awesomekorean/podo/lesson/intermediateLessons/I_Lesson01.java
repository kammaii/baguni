package net.awesomekorean.podo.lesson.intermediateLessons;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class I_Lesson01 extends LessonInit_Lock implements I_Lesson, LessonItem, Serializable {

    private String lessonId = "IL_01";
    private String lessonTitle = "order";
    private String lessonSubTitle = "음식 주문";

    private String[] dialog = {
            "어서 오세요.\n몇 분이에요?",
            "두 명이에요.",
            "이쪽으로 오세요.\n여기에 앉으세요.",
            "고맙습니다.\n메뉴(menu) 좀 주세요.",
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
            "알겠습니다.\n(잠시 후)",
            "배고파요.",
            "음식 나왔습니다.",
            "잘 먹겠습니다.",
            "(다 먹은 후)\n맛있게 드셨어요?",
            "네, 잘 먹었습니다.",
            "디저트 드릴까요?",
            "뭐 있어요?",
            "커피랑 아이스크림 있어요.",
            "커피 주세요.",
            "네.\n(다 먹은 후)",
            "얼마예요?",
            "20,000원 입니다.",
            "여기요.",
            "감사합니다.\n다음에 또 오세요.",
            "네, 잘먹었습니다."
    };

    private String[] dialogEng = {
            "welcome.\nHow many people?",
            "Two.",
            "Come here.\nPlease take a seat.",
            "Thank you.\nmenu, please.",
            "Yes, here it is.",
            "Do you have a recommended menu?",
            "Yes, this and this are delicious.",
            "I'll order in a minute.",
            "Yes, take your time.\n(After a while)",
            "Here.",
            "Are you ready to order?",
            "Yes, this and this, please.",
            "Ok, anything to drink?",
            "water, please.",
            "Ok, would you like anything else?",
            "Ah! Not too spicy, please.",
            "I see.\n(After a while)",
            "I'm hungry.",
            "Food came out.",
            "Thank you.",
            "(After eating)\nDid you enjoy the meal?",
            "Yes, thank you for the meal.",
            "Do you want some dessert?",
            "What do you have?",
            "coffee and ice cream.",
            "Coffee, please.",
            "Yes.\n(After eating)",
            "How much is it?",
            "It is 20,000 won.",
            "Here you go.",
            "Thank you.\nCome again next time.",
            "Yes, thank you for the meal."
    };

    private int[] peopleImage = {R.drawable.people3, R.drawable.people4};

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
