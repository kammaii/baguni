package net.awesomekorean.podo.lesson.lessonNumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UserInformation;

public class LessonNumberMenu extends AppCompatActivity implements View.OnClickListener {

    ImageView btnBack;

    Context context;

    UserInformation userInformation;

    LinearLayout layoutSino;
    LinearLayout layoutNative;
    LinearLayout layoutDate;
    LinearLayout layoutAge;
    LinearLayout layoutMoney;
    LinearLayout layoutTime;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_number_menu);

        context = getApplicationContext();
        userInformation = SharedPreferencesInfo.getUserInfo(context);

        btnBack = findViewById(R.id.btnBack);
        layoutSino = findViewById(R.id.layoutSino);
        layoutNative = findViewById(R.id.layoutNative);
        layoutDate = findViewById(R.id.layoutDate);
        layoutAge = findViewById(R.id.layoutAge);
        layoutMoney = findViewById(R.id.layoutMoney);
        layoutTime = findViewById(R.id.layoutTime);
        btnBack.setOnClickListener(this);
        layoutSino.setOnClickListener(this);
        layoutNative.setOnClickListener(this);
        layoutDate.setOnClickListener(this);
        layoutAge.setOnClickListener(this);
        layoutMoney.setOnClickListener(this);
        layoutTime.setOnClickListener(this);
    }


    private void openLessonNumber(String value) {
        Intent intent = new Intent(context, LessonNumberFrame.class);
        intent.putExtra(getString(R.string.EXTRA_ID), value);
        intent.putExtra("isNumberPractice", true);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnBack :
                finish();
                break;

            case R.id.layoutSino :
                openLessonNumber(getString(R.string.SINO));
                break;

            case R.id.layoutNative :
                openLessonNumber(getString(R.string.NATIVE));
                break;

            case R.id.layoutDate :
                openLessonNumber(getString(R.string.DATE));
                break;

            case R.id.layoutAge :
                openLessonNumber(getString(R.string.AGE));
                break;

            case R.id.layoutMoney :
                openLessonNumber(getString(R.string.MONEY));
                break;

            case R.id.layoutTime :
                openLessonNumber(getString(R.string.TIME));
                break;
        }
    }
}
