package net.awesomekorean.podo.lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.awesomekorean.podo.R;

public class LessonVideo extends AppCompatActivity implements View.OnClickListener {

    TextView title;
    ImageView btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_video);

        title = findViewById(R.id.title);
        btnBack = findViewById(R.id.btnBack);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnBack :
                finish();
                break;
        }
    }
}