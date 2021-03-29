package net.awesomekorean.podo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DialogueActivityType1 extends AppCompatActivity implements View.OnClickListener {

    TextView tvContents;
    Button btnYes;
    ImageView btnClose;

    String contents;
    String btnText;

    final String CONTENTS = "contents";
    final String BTN_TEXT = "btnText";



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
        tvContents.setText(contents);
        btnYes.setText(btnText);
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnYes :
                setResult(RESULT_OK);
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