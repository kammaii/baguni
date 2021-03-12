package net.awesomekorean.podo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.awesomekorean.podo.challenge.Challenge;

public class DialogueActivityType1 extends AppCompatActivity implements View.OnClickListener {

    TextView tvContents;
    Button btnYes;
    ImageView btnClose;

    String contents;
    String btnText;
    boolean isForChallenger;

    final String CONTENTS = "contents";
    final String BTN_TEXT = "btnText";
    final String IS_FOR_CHALLENGER = "isForChallenger";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogue_type1);

        tvContents = findViewById(R.id.tvContents);
        btnYes = findViewById(R.id.btnYes);
        btnClose = findViewById(R.id.btnClose);
        btnYes.setOnClickListener(this);
        btnClose.setOnClickListener(this);

        contents = getIntent().getStringExtra(CONTENTS);
        btnText = getIntent().getStringExtra(BTN_TEXT);
        isForChallenger = getIntent().getBooleanExtra(IS_FOR_CHALLENGER, false);
        tvContents.setText(contents);
        btnYes.setText(btnText);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnYes :
                if(isForChallenger) {
                    Intent intent = new Intent(getApplicationContext(), Challenge.class);
                    startActivity(intent);
                } else {
                    setResult(RESULT_OK);
                }
                finish();
                break;


            case R.id.btnClose :
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