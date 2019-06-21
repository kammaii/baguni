package net.awesomekorean.baguni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.awesomekorean.baguni.lesson.LessonHangul;

public class LessonHangulMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_hangul_menu);
    }

    public void btnclick1(View v) {
        Intent intent = new Intent(getApplicationContext(), LessonHangul.class);
        intent.putExtra("conVowBat", "consonant");
        startActivity(intent);
    }

    public void btnclick2(View v) {
        Intent intent = new Intent(getApplicationContext(), LessonHangul.class);
        intent.putExtra("conVowBat", "vowel");
        startActivity(intent);
    }

}
