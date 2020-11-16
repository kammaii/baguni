package net.awesomekorean.podo.lesson.lessonNumber;

import net.awesomekorean.podo.lesson.lessons.LessonInit;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

public class LessonNumber extends LessonInit implements LessonItem {

    private String lessonId = "N_number";
    private String lessonTitle = "numbers";
    private String lessonSubTitle = "숫자";
    private Integer dayCount = 5;

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


