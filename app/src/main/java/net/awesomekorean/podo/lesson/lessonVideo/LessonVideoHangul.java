package net.awesomekorean.podo.lesson.lessonVideo;

import net.awesomekorean.podo.R;

public class LessonVideoHangul implements Video {

    String title = "Hangul";
    int[] videoImage = {R.drawable.thumbnail, R.drawable.thumbnail};
    String[] videoTitle = {"Intro", "ㅏ,ㅑ,ㅓ,ㅕ,ㅗ,ㅛ,ㅡ,ㅣ"};
    String[] videoId = {"mP4yU2tWtn0", "jjjj"};
    String[] videoLength = {"0:48", "10:00"};

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
