package net.awesomekorean.podo.lesson.lessonNumber.numbers;

import net.awesomekorean.podo.lesson.lessons.LessonItem;
import net.awesomekorean.podo.lesson.lessons.LessonInit_Lock;

import java.io.Serializable;

public class NumberPractice extends LessonInit_Lock implements LessonItem, Serializable {

    private String lessonId = "N_practice";

    private String lessonTitle = "Practice";

    private String lessonSubTitle = "time, date, age...";


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

}
