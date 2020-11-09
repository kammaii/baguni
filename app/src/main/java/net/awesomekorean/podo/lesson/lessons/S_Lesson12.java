package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class S_Lesson12 extends LessonInit_Lock implements LessonItem, LessonSpecial, Serializable {

    private String lessonId = "SL_12";
    private String lessonTitle = "confusing expression";
    private String lessonSubTitle = "아/어서 vs 으니까";

    private int contents = R.string.SL_12_CONTENTS;

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

    @Override
    public int getContents() {
        return contents;
    }
}

