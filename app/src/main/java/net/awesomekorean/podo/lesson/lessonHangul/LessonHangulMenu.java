package net.awesomekorean.podo.lesson.lessonHangul;

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

public class LessonHangulMenu extends AppCompatActivity implements View.OnClickListener {

    ImageView btnBack;
    Context context;
    UserInformation userInformation;

    LinearLayout layoutConsonant;
    LinearLayout layoutVowel;
    LinearLayout layoutBatchim;
    LinearLayout layoutAssembly;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_hangul_menu);

        context = getApplicationContext();
        userInformation = SharedPreferencesInfo.getUserInfo(context);

        btnBack = findViewById(R.id.btnBack);
        layoutConsonant = findViewById(R.id.layoutConsonant);
        layoutVowel = findViewById(R.id.layoutVowel);
        layoutBatchim = findViewById(R.id.layoutBatchim);
        layoutAssembly = findViewById(R.id.layoutAssembly);
        btnBack.setOnClickListener(this);
        layoutConsonant.setOnClickListener(this);
        layoutVowel.setOnClickListener(this);
        layoutBatchim.setOnClickListener(this);
        layoutAssembly.setOnClickListener(this);
    }


    private void openLessonHangul(String hangul) {
        if(hangul.equals(context.getString(R.string.ASSEMBLY))) {
            intent = new Intent(context, LessonHangulAssembly.class);

        } else {
            intent = new Intent(context, LessonHangulFrame.class);
            intent.putExtra(context.getResources().getString(R.string.CONVOWBAT), hangul);
        }
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnBack :
                finish();
                break;

            case R.id.layoutConsonant :
                openLessonHangul(getString(R.string.CONSONANT));
                break;

            case R.id.layoutVowel :
                openLessonHangul(getString(R.string.VOWEL));
                break;

            case R.id.layoutBatchim :
                openLessonHangul(getString(R.string.BATCHIM));
                break;

            case R.id.layoutAssembly :
                openLessonHangul(getString(R.string.ASSEMBLY));
                break;
        }
    }
}
