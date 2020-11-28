package net.awesomekorean.podo.lesson.lessonReviewRewards;

import net.awesomekorean.podo.lesson.lessons.Lesson;
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

public class LessonReview06 extends LessonInit implements LessonItem, LessonReview, Serializable {

    private String lessonId = "LR_06";
    private String lessonTitle = "";
    private String lessonSubTitle = "";


    private Lesson[] lessons = {
            new Lesson41(), new Lesson42(), new Lesson43(), new Lesson44(), new Lesson45()
    };

    private String[] baseForm = {
            "돌아가다", "앉다", "입다", "벗다", "바꾸다", "확인하다", "전화하다"
    };

    private String[][] conjugation = {
            {"돌아가기로 했어요", "돌아갈래요?", "돌아갈까요?"},
            {"앉을래요?", "앉을까요?", "앉으시다", "앉습니다"},
            {"입을래요?", "입을까요?", "입으시다", "입습니다"},
            {"벗을래요?", "벗을까요?", "벗으시다", "벗습니다"},
            {"바꾸기로 했어요", "바꿀래요?", "바꿀까요?", "바꾸시다", "바꿉니다"},
            {"확인하기로 했어요", "확인할래요?", "확인할까요?", "확인하시다", "확인합니다"},
            {"전화하기로 했어요", "전화할래요?", "전화할까요?", "전화하시다", "전화합니다"}
    };

    private String[][] translate = {
            {"I decided to go back", "Would you like to go back?", "Should I(Shall we) go back?"},
            {"Would you like to sit down?", "Should I(Shall we) sit down?", "Sit down (honorific)", "Sit down (formal)"},
            {"Would you like to put it on?", "Should I(Shall we) put it on?", "Put on (honorific)", "Put on (formal)"},
            {"Would you like to take it off?", "Should I(Shall we) take it off?", "Take off (honorific)", "Take off (formal)"},
            {"I decided to change it", "Would you like to change it?", "Should I(Shall we) change it?", "Change (honorific)", "Change (formal)"},
            {"I decided to check it", "Would you like to check it?", "Should I(Shall we) check it?", "Check (honorific)", "Check (formal)"},
            {"I decided to call", "Would you like to call?", "Should I call you? (Shall we call him?)", "Call (honorific)", "Call (formal) "}
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
