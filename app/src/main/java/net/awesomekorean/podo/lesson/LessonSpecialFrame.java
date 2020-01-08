package net.awesomekorean.podo.lesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import net.awesomekorean.podo.MainActivity;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UserInformation;
import net.awesomekorean.podo.lesson.lessons.S_Lesson1;

public class LessonSpecialFrame extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    TextView title;
    TextView contents;
    Button btnFinish;
    
    LessonSpecial lessonSpecial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_special_frame);

        title = findViewById(R.id.title);
        contents = findViewById(R.id.contents);
        btnFinish = findViewById(R.id.btnFinish);
        contents.setMovementMethod(new ScrollingMovementMethod());
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 레슨완료 정보 업데이트 하기
                String lessonId = MainLesson.lessonId;
                UserInformation userInformation = SharedPreferencesInfo.getUserInfo(getApplicationContext());
                if(!userInformation.getLessonComplete().contains(lessonId)) {
                    userInformation.addLessonComplete(lessonId);
                    SharedPreferencesInfo.setUserInfo(getApplicationContext(), userInformation);
                    db.collection(getString(R.string.DB_USERS)).document(MainActivity.userEmail).collection(getString(R.string.DB_INFORMATION)).document(getString(R.string.DB_INFORMATION)).set(userInformation);
                    System.out.println("Lesson 완료 리스트를 업데이트 했습니다.");
                } else {
                    System.out.println("이미 완료된 Lesson 입니다.");
                }

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        Intent intent = getIntent();

        switch(MainLesson.lessonId) {
            
            case "SL_01":
                lessonSpecial = new S_Lesson1();
                readyForLesson();
                break;
        }

    }

    private void readyForLesson() {
        title.setText(lessonSpecial.getTitle());
        contents.setText(lessonSpecial.getContents());
    }
}
