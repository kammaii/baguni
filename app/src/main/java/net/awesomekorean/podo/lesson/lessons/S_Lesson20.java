package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class S_Lesson20 extends LessonInit_Lock implements LessonItem, LessonSpecial, Serializable {

    private String lessonId = "SL_20";
    private String lessonTitle = "more expression";
    private String lessonSubTitle = "honorific";

    private int contents = R.string.SL_20_CONTENTS;

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

