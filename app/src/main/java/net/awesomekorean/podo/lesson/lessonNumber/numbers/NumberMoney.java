package net.awesomekorean.podo.lesson.lessonNumber.numbers;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.lesson.lessons.LessonInit;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

public class NumberMoney extends LessonInit implements Number, LessonItem {

    private String lessonId = "N_money";

    private String lessonTitle = "money";

    private String lessonSubTitle = "";

    private int lessonImage = R.drawable.numbermoney;

    private String[] front = {
            "100 원", "150 원", "230 원", "260 원", "330 원", "390 원", "410 원", "460 원", "530 원", "580 원",
            "600 원", "690 원", "740 원", "810 원", "890 원", "930 원", "990 원", "1,000 원", "1,200 원", "2,500 원",
            "2,900 원", "3,300 원", "3,700 원", "4,100 원", "4,200 원", "5,000 원", "5,600 원", "6,200 원", "6,900 원",
            "7,300 원", "7,600 원", "8,100 원", "8,200 원", "9,700 원", "9,900 원", "10,000 원", "12,000 원", "21,000 원",
            "29,000 원", "34,000 원", "38,000 원", "43,000 원", "45,000 원", "55,000 원", "58,000 원", "66,000 원", "69,000 원",
            "70,000 원", "71,000 원", "82,000 원", "86,000 원", "94,000 원", "99,000 원", "100,000 원"
    };

    private String[] back = {
            "백 원[배권]", "백 오십 원", "이백 삼십 원", "이백 육십 원", "삼백 삼십 원", "삼백 구십 원", "사백 십 원",
            "사백 육십 원", "오백 삼십 원", "오백 팔십 원", "육백 원", "육백 구십 원", "칠백 사십 원", "팔백 십 원",
            "팔백 구십 원", "구백 삼십 원", "구백 구십 원", "천 원", "천 이백 원", "이천 오백 원", "이천 구백 원",
            "삼천 삼백 원", "삼천 칠백 원", "사천 백 원", "사천 이백 원", "오천 원", "오천 육백 원", "육천 이백 원",
            "육천 구백 원", "칠천 삼백 원", "칠천 육백 원", "팔천 백 원", "팔천 이백 원", "구천 칠백 원", "구천 구백 원",
            "만 원", "만 이천 원", "이만 천 원", "이만 구천 원", "삼만 사천 원", "삼만 팔천 원", "사만 삼천 원",
            "사만 오천 원", "오만 오천 원", "오만 팔천 원", "육만[융만] 육천 원", "육만[융만] 구천 원", "칠만 원",
            "칠만 천 원", "팔만 이천 원", "팔만 육천 원", "구만 사천 원", "구만 구천 원", "십만 원[심마눤]"
    };


    @Override
    public String getLessonSubTitle() {
        return lessonSubTitle;
    }

    @Override
    public String getLessonId() {
        return lessonId;
    }

    @Override
    public String getLessonTitle() {
        return lessonTitle;
    }

    public int getLessonImage() {
        return lessonImage;
    }

    @Override
    public String[] getFront() {
        return front;
    }

    @Override
    public String[] getBack() {
        return back;
    }
}
