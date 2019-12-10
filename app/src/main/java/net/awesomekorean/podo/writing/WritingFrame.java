package net.awesomekorean.podo.writing;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.teachers.Teachers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WritingFrame extends AppCompatActivity implements View.OnClickListener {

    TextView textCount; // 글자 수 표시
    EditText editText; // 쓰기 입력
    LinearLayout saveResult; //저장 메시지

    public static String guid;
    String article;
    String letters;

    ImageView btnBack;
    Button btnSave;
    Button btnCorrection;

    LinearLayout tips;
    ImageView btnClose;

    String code; // add 인지 edit 인지를 판별

    WritingRepository repository;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_writing_frame);

        textCount = findViewById(R.id.textCount);
        editText = findViewById(R.id.editText);
        btnSave = findViewById(R.id.btnSave);
        btnCorrection = findViewById(R.id.btnCorrection);
        saveResult = findViewById(R.id.saveResult);
        btnBack = findViewById(R.id.btnBack);
        tips = findViewById(R.id.tips);
        btnClose = findViewById(R.id.btnClose);
        btnBack.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnCorrection.setOnClickListener(this);
        btnClose.setOnClickListener(this);

        intent = getIntent();
        code = intent.getExtras().getString(getString(R.string.REQUEST));

        // EDIT 일 때, 기존의 글을 출력
        if(code.equals(getString(R.string.REQUEST_EDIT))) {
            guid = intent.getExtras().getString(getString(R.string.EXTRA_GUID));
            article = intent.getExtras().getString(getString(R.string.EXTRA_ARTICLE));
            letters = intent.getExtras().getString(getString(R.string.EXTRA_LETTERS));
            editText.setText(article);
            textCount.setText(letters);
        }

        // 글을 쓸 때 바로바로 글자수를 가져옴
       editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                String input = editText.getText().toString();
                textCount.setText(input.length() + " " + getString(R.string.LETTERS));
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });

        // 에디트텍스트뷰 스크롤 가능하게 해줌
        editText = findViewById(R.id.editText);
        editText.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                // TODO Auto-generated method stub
                if (view.getId() ==R.id.editText) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    switch (event.getAction()&MotionEvent.ACTION_MASK){
                        case MotionEvent.ACTION_UP:
                            view.getParent().requestDisallowInterceptTouchEvent(false);
                            break;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnSave :
                saveWriting();
                saveResult.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        saveResult.setVisibility(View.GONE);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }, 1000);
                break;

            case R.id.btnCorrection :
                WritingEntity entity = saveWriting();
                Toast.makeText(getApplicationContext(), getString(R.string.WRITING_SAVED), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, Teachers.class);
                intent.putExtra("code", "correction");
                intent.putExtra("ENTITY", entity);
                startActivity(intent);
                finish();
                break;

            case R.id.btnBack :
                finish();
                break;

            case R.id.btnClose :
                tips.setVisibility(View.GONE);
                break;
        }
    }

    private WritingEntity saveWriting() {
        article = editText.getText().toString();
        letters = textCount.getText().toString();
        String date = new SimpleDateFormat("yyyy.MM.dd").format(new Date());

        if(code.equals(getString(R.string.REQUEST_ADD))) {
            WritingEntity entity = new WritingEntity(article, letters, date);
            guid = entity.getGuid();
            System.out.println("DATE : " + entity.getWritingDate());
            repository = new WritingRepository(this);
            repository.insert(entity);

            return entity;


        }else{
            repository = new WritingRepository(this);
            repository.editByGuid(guid, article, letters);
            return null;
        }
    }
}
