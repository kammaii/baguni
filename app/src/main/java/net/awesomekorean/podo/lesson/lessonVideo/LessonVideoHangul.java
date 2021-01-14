package net.awesomekorean.podo.lesson.lessonVideo;

public class LessonVideoHangul implements Video{

    String title = "Hangul";
    int[] videoImage = {};
    String[] videoTitle = {};
    String[] videoFile = {};

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
    public String[] getVideoFile() {
        return videoFile;
    }
}
