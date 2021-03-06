package net.awesomekorean.podo.reading.readings;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.reading.Reading;

import java.io.Serializable;

public class Reading05 extends ReadingInit implements Reading, Serializable {

    String readingId = "R_05";
    int readingLevel = 2;
    final String title = "한국의 김장문화";


    final String[] article = {
            "한국 사람들은 추운 겨울이 오기 전에 ",
            "내년",
            "에 먹을 많은 김치를 만듭니다.\n이것을 ‘김장’이라고 하고 이 ",
            "시기",
            "를 ‘김장철’이라고 합니다. \n\n한국에서 김장을 할 때 ",
            "이웃",
            "들과 ",
            "서로",
            " ",
            "도와주",
            "는 문화가 있습니다. \n11월에서 12월 사이에 김장하는 날을 알려주면 이웃들이 집에 와서 김장을 도와줍니다. \n그리고 김장이 끝나면 만든 김치를 사람들에게 조금씩 ",
            "나누어 줍",
            "니다.\n김장을 하는 동안 재미있는 이야기도 하면서 이웃들과 더 친해질 수 있습니다.\n\n이렇게 만든 많은 김치는 김치 냉장고에 ",
            "보관하",
            "면 시간에 따라 맛이 달라집니다. \n그래서 1년 동안 ",
            "다양한",
            " 맛의 김치를 먹을 수 있습니다.\n\n"
    };

    final String[] popUpFront = {"내년", "시기", "이웃", "서로", "도와주다", "나누어 주다", "보관하다", "다양하다"};
    final String[] popUpBack = {"next year", "period", "neighbor", "each other", "help", "give out", "store", "various"};

    private int readingImage = R.drawable.kimjang;

    @Override
    public String getReadingId() {
        return readingId;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String[] getArticle() {
        return article;
    }

    @Override
    public String[] getPopUpFront() {
        return popUpFront;
    }

    @Override
    public String[] getPopUpBack() {
        return popUpBack;
    }

    @Override
    public int getReadingImage() {
        return this.readingImage;
    }

    @Override
    public int getReadingLevel() {
        return this.readingLevel;
    }
}
