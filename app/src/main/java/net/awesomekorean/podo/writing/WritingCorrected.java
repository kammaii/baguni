package net.awesomekorean.podo.writing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import net.awesomekorean.podo.R;

public class WritingCorrected extends AppCompatActivity implements View.OnClickListener {

    TextView writingOriginal;
    TextView writingCorrected;
    TextView feedbackTeacher;

    ImageView btnBack;

    String guid;
    String article;
    String correction;
    String comment;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_corrected);

        writingOriginal = findViewById(R.id.writingOriginal);
        writingCorrected = findViewById(R.id.writingCorrected);
        feedbackTeacher = findViewById(R.id.feedbackTeacher);
        btnBack = findViewById(R.id.btnBack);
        writingOriginal.setMovementMethod(new ScrollingMovementMethod());
        writingCorrected.setMovementMethod(new ScrollingMovementMethod());
        feedbackTeacher.setMovementMethod(new ScrollingMovementMethod());
        btnBack.setOnClickListener(this);

        intent = getIntent();

        WritingEntity correctedWriting = (WritingEntity) intent.getSerializableExtra(getString(R.string.EXTRA_ENTITY));
        guid = correctedWriting.getGuid();
        article = correctedWriting.getContents();
        correction = correctedWriting.getCorrection();
        comment = correctedWriting.getTeacherFeedback();

        writingOriginal.setText(article);
        if(correction != null) {
            writingCorrected.setText(Html.fromHtml(correction));
        }
        if(comment != null) {
            feedbackTeacher.setText(comment);
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnBack :
                finish();
                break;
        }
    }
}
