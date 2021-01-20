package net.awesomekorean.podo.lesson.lessonVideo;

import net.awesomekorean.podo.R;

public class LessonVideoHangul implements Video {

    String title = "Hangul";
    int[] videoImage = {
            R.drawable.hangul00, R.drawable.hangul01, R.drawable.hangul02,
            R.drawable.hangul03, R.drawable.hangul04, R.drawable.hangul05,
            R.drawable.hangul06, R.drawable.hangul07, R.drawable.hangul08,
            R.drawable.hangul09};
    String[] videoTitle = {
            "Intro", "ㅏ,ㅓ,ㅗ,ㅜ,ㅡ,ㅣ", "ㄱ,ㄴ,ㅁ,ㅅ", "ㅑ,ㅕ,ㅛ,ㅠ", "ㄷ,ㄹ,ㅂ,ㅈ",
            "ㄱ,ㄴ,ㄹ,ㅁ,ㅂ,ㅇ,ㄷ,ㅅ,ㅈ", "ㅐ,ㅔ,ㅒ,ㅖ", "ㅋ,ㅍ,ㅌ,ㅊ,ㅎ", "ㅘ,ㅝ,ㅙ,ㅞ,ㅚ,ㅟ,ㅚ", "ㄲ,ㅃ,ㄸ,ㅆ,ㅉ"};
    String[] videoId = {
            "mP4yU2tWtn0", "3xP1EyHJh6g", "47LZ-GrYrz4", "UXsRZJaVjyQ", "l3ouwQ3l_2g",
            "h1iWxQT2U5k", "YFrliCF2kWA", "J8TZEAd4mzo", "r9_IeMM09d8", "pWBOHngyek0"};
    String[] videoLength = {"0:48", "2.49", "4:05", "1:37", "3:20", "6:58", "1:17", "2:38", "2:32", "3:35"};

    public String getTitle() {
        return title;
    }

    @Override
    public String[] getVideoTitle() {
        return videoTitle;
    }

    @Override
    public int[] getVideoImage() {
        return videoImage;
    }

    @Override
    public String[] getVideoId() {
        return videoId;
    }

    @Override
    public String[] getVideoLength() {
        return videoLength;
    }
}
