package net.awesomekorean.podo.lesson.lessons;

import net.awesomekorean.podo.R;

import java.io.Serializable;

public class S_Lesson19 extends LessonInit_Lock implements LessonItem, LessonSpecial, Serializable {

    private String lessonId = "SL_19";
    private String lessonTitle = "confusing expression";
    private String lessonSubTitle = "~(으)ㄹ래요? vs.\n~(으)까요?";

    private int contents = R.string.SL_19_CONTENTS;

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

