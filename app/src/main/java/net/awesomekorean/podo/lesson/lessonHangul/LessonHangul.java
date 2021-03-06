package net.awesomekorean.podo.lesson.lessonHangul;

import net.awesomekorean.podo.lesson.lessons.LessonInit;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

public class LessonHangul extends LessonInit implements LessonItem {

    private String lessonId = "H_hangul";
    private String lessonTitle = "Hangul";
    private String lessonSubTitle = "한글";
    private Integer dayCount = 1;
    private boolean hasVideo = true;

    @Override
    public String getLessonId() {
        return lessonId;
    }

    @Override
    public String getLessonTitle() {
        return lessonTitle;
    }

    @Override
    public String getLessonSubTitle() {
        return lessonSubTitle;
    }

    @Override
    public Integer getDayCount() {
        return dayCount;
    }

    @Override
    public boolean getHasVideo() {
        return hasVideo;
    }
}


