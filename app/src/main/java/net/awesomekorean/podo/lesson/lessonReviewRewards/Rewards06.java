package net.awesomekorean.podo.lesson.lessonReviewRewards;

import net.awesomekorean.podo.lesson.lessons.LessonInit;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class Rewards06 extends LessonInit implements LessonItem, Serializable {

    private String lessonId = "RW_06";
    private String lessonTitle = "";
    private String lessonSubTitle = "";
    private Integer dayCount = 25;



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

}
