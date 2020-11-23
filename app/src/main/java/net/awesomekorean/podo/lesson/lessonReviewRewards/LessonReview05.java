package net.awesomekorean.podo.lesson.lessonReviewRewards;

import net.awesomekorean.podo.lesson.lessons.Lesson;
import net.awesomekorean.podo.lesson.lessons.Lesson24;
import net.awesomekorean.podo.lesson.lessons.Lesson25;
import net.awesomekorean.podo.lesson.lessons.Lesson26;
import net.awesomekorean.podo.lesson.lessons.Lesson30;
import net.awesomekorean.podo.lesson.lessons.Lesson31;
import net.awesomekorean.podo.lesson.lessons.Lesson32;
import net.awesomekorean.podo.lesson.lessons.Lesson33;
import net.awesomekorean.podo.lesson.lessons.Lesson34;
import net.awesomekorean.podo.lesson.lessons.Lesson36;
import net.awesomekorean.podo.lesson.lessons.Lesson37;
import net.awesomekorean.podo.lesson.lessons.Lesson38;
import net.awesomekorean.podo.lesson.lessons.Lesson39;
import net.awesomekorean.podo.lesson.lessons.Lesson40;
import net.awesomekorean.podo.lesson.lessons.Lesson41;
import net.awesomekorean.podo.lesson.lessons.Lesson42;
import net.awesomekorean.podo.lesson.lessons.Lesson43;
import net.awesomekorean.podo.lesson.lessons.Lesson44;
import net.awesomekorean.podo.lesson.lessons.Lesson45;
import net.awesomekorean.podo.lesson.lessons.LessonInit;
import net.awesomekorean.podo.lesson.lessons.LessonItem;

import java.io.Serializable;

public class LessonReview05 extends LessonInit implements LessonItem, LessonReview, Serializable {

    private String lessonId = "LR_05";
    private String lessonTitle = "";
    private String lessonSubTitle = "";


    private Lesson[] lessons = {
            new Lesson36(), new Lesson37(), new Lesson38(), new Lesson39(), new Lesson40()
    };

    private String[] baseForm = {
            "주문하다", "찾다", "축하하다", "만나다", "기억하다"
    };

    private String[][] conjugation = {
            {"주문하지 마세요", "주문하지 않아도 돼요", "주문하러 가다", "주문하려고"},
            {"찾지 마세요", "찾으면 안 돼요", "찾지 않아도 돼요", "찾으러 가다", "찾으려고"},
            {"축하하지 않아도 돼요", "축하하러 가다", "축하하려고"},
            {"만나지 마세요", "만나면 안 돼요", "만나지 않아도 돼요", "만나러 가다", "만나려고"},
            {"기억하면 안 돼요", "기억하지 않아도 돼요", "기억하려고"}
    };

    private String[][] translate = {
            {"Don't order", "You don't have to order", "Go to order", "To order"},
            {"Don't find", "Can't find it", "You don't have to look for it", "Go to find", "To find"},
            {"You don't have to celebrate", "Go to celebrate", "To celebrate"},
            {"Don't meet", "Can't meet", "You don't have to meet", "Go to meet", "To meet"},
            {"Can't remember", "You don't have to remember", "To remember"}
    };


    public String[] getBaseForm() {
        return baseForm;
    }

    public String[][] getConjugation() {
        return conjugation;
    }

    public String[][] getTranslate() {
        return translate;
    }

    public Lesson[] getLessons() {
        return lessons;
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
    public String getLessonSubTitle() {
        return lessonSubTitle;
    }
}
