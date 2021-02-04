package net.awesomekorean.podo.lesson.lessonVideo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.awesomekorean.podo.DialogueActivityType1;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.challenge.Challenge;

public class LessonVideoMenu extends AppCompatActivity implements View.OnClickListener {

    TextView title;
    ImageView btnBack;
    LessonVideoAdapter adapter;
    String videoTitle;
    Intent intent;

    Video lessonVideo;

    final String HANGUL = "H_hangul";
    final String VIDEO = "video";
    final String BTN_TEXT = "btnText";
    final String CONTENTS = "contents";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_video_menu);

        title = findViewById(R.id.title);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(this);

        intent = getIntent();
        videoTitle = intent.getStringExtra(getResources().getString(R.string.LESSON));

        switch (videoTitle) {

            case HANGUL :
                lessonVideo = new LessonVideoHangul();
                title.setText(lessonVideo.getTitle());
                break;
        }

        adapter = new LessonVideoAdapter(getApplicationContext(), lessonVideo);
        adapter.setOnItemClickListener(new LessonVideoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {

                int isChallenger = SharedPreferencesInfo.getUserInfo(getApplicationContext()).getIsChallenger();

                if(pos !=0 && pos !=1 && isChallenger == 0) {
                    // 챌린저 권유창 띄우기
                    intent = new Intent(getApplicationContext(), DialogueActivityType1.class);
                    intent.putExtra(CONTENTS, getResources().getString(R.string.VIDEO_DIALOGUE_CONTENTS));
                    intent.putExtra(BTN_TEXT, getResources().getString(R.string.VIDEO_DIALOGUE_BTN_TEXT));
                    startActivityForResult(intent, 200);

                } else {
                    intent = new Intent(getApplicationContext(), VideoFrame.class);
                    intent.putExtra(VIDEO, lessonVideo.getVideoId()[pos]);
                    startActivity(intent);
                }
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // 챌린지 페이지로 이동
        if(resultCode == RESULT_OK) {
            intent = new Intent(getApplicationContext(), Challenge.class);
            startActivity(intent);
        }
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