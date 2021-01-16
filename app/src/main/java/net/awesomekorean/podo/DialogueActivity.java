package net.awesomekorean.podo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DialogueActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvTitle;
    TextView tvContents;
    Button btnYes;
    Button btnNo;

    String title;
    String contents;
    final String TITLE = "title";
    final String CONTENTS = "contents";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue);

        tvTitle = findViewById(R.id.tvTitle);
        tvContents = findViewById(R.id.tvContents);
        btnYes = findViewById(R.id.btnYes);
        btnNo = findViewById(R.id.btnNo);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

        title = getIntent().getStringExtra(TITLE);
        contents = getIntent().getStringExtra(CONTENTS);
        tvTitle.setText(title);
        tvContents.setText(contents);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnYes :
                setResult(RESULT_OK);
                finish();
                break;


            case R.id.btnNo :
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}