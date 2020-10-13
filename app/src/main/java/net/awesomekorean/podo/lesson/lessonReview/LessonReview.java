package net.awesomekorean.podo.lesson.lessonReview;

import net.awesomekorean.podo.lesson.lessons.Lesson;

public interface LessonReview {

    String getLessonId();

    String[] getBaseForm();

    String[][] getConjugation();

    String[][] getTranslate();

    Lesson[] getLessons();
}
