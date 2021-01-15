package net.awesomekorean.podo.lesson.lessonVideo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.awesomekorean.podo.R;

public class LessonVideo extends AppCompatActivity implements View.OnClickListener {

    TextView title;
    ImageView btnBack;
    LessonVideoAdapter adapter;
    String videoTitle;
    Intent intent;

    final String HANGUL = "H_hangul";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_video);

        title = findViewById(R.id.title);
        btnBack = findViewById(R.id.btnBack);

        intent = getIntent();
        videoTitle = intent.getStringExtra(getResources().getString(R.string.LESSON));

        if(videoTitle.equals(HANGUL)) {
            adapter = new LessonVideoAdapter(getApplicationContext(), new LessonVideoHangul());
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
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