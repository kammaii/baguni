package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class S_Lesson03 extends LessonInit_Lock implements LessonItem, LessonSpecial, Serializable {

    private String lessonId = "SL_03";
    private String lessonTitle = "conjugation";
    private String lessonSubTitle = "아/어요";

    private int contents = R.string.SL_03_CONTENTS;

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

