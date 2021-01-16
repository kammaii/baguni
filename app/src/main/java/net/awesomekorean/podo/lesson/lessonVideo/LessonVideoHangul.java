package net.awesomekorean.podo.lesson.lessonVideo;

import net.awesomekorean.podo.R;

public class LessonVideoHangul implements Video {

    String title = "Hangul";
    int[] videoImage = {R.drawable.female_p, R.drawable.friend_b};
    String[] videoTitle = {"Intro", "2번비디오"};
    String[] videoId = {"mP4yU2tWtn0", "jjjj"};

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
}
