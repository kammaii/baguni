package net.awesomekorean.podo.challenge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.awesomekorean.podo.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class Challenge extends AppCompatActivity implements View.OnClickListener {

    FragmentPagerAdapter adapter;
    ArrayList<Integer> imageList;

    ImageView btnBack;
    TextView interview1;
    TextView interview2;
    TextView interview3;
    ImageView interviewFold1;
    ImageView interviewFold2;
    ImageView interviewFold3;
    Button btnChallenge;
    TextView textChallenge;

    boolean interviewClicked1 = false;
    boolean interviewClicked2 = false;
    boolean interviewClicked3 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        btnBack = findViewById(R.id.btnBack);
        interview1 = findViewById(R.id.interview_1);
        interview2 = findViewById(R.id.interview_2);
        interview3 = findViewById(R.id.interview_3);
        interviewFold1 = findViewById(R.id.interview_fold_1);
        interviewFold2 = findViewById(R.id.interview_fold_2);
        interviewFold3 = findViewById(R.id.interview_fold_3);
        btnChallenge = findViewById(R.id.btnChallenge);
        textChallenge = findViewById(R.id.textChallenge);
        btnBack.setOnClickListener(this);
        interviewFold1.setOnClickListener(this);
        interviewFold2.setOnClickListener(this);
        interviewFold3.setOnClickListener(this);
        btnChallenge.setOnClickListener(this);


        imageList = new ArrayList<>();
        imageList.add(R.drawable.benefits_ads);
        imageList.add(R.drawable.benefits_lessons);
        imageList.add(R.drawable.benefits_progress);
        imageList.add(R.drawable.benefits_points);

        ViewPager viewPager = findViewById(R.id.viewPager);
        adapter = new ChallengeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        Shader shader = new LinearGradient(0,0,100,0, new int[]{ContextCompat.getColor(getApplicationContext(), R.color.PINK2), ContextCompat.getColor(getApplicationContext(), R.color.PURPLE)}, new float[]{0, 1}, Shader.TileMode.CLAMP);
        textChallenge.getPaint().setShader(shader);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnBack :
                finish();
                break;

            case R.id.interview_fold_1 :
                if(!interviewClicked1) {
                    interviewClicked1 = true;
                    interview1.setText(getResources().getString(R.string.INTERVIEW_1_DETAIL));
                    interviewFold1.setImageResource(R.drawable.fold_up_red);
                } else {
                    interviewClicked1 = false;
                    interview1.setText(getResources().getString(R.string.INTERVIEW_1_SUMMARY));
                    interviewFold1.setImageResource(R.drawable.fold_down_red);
                }
                break;

            case R.id.interview_fold_2 :
                if(!interviewClicked2) {
                    interviewClicked2 = true;
                    interview2.setText(getResources().getString(R.string.INTERVIEW_2_DETAIL));
                    interviewFold2.setImageResource(R.drawable.fold_up_red);

                } else {
                    interviewClicked2 = false;
                    interview2.setText(getResources().getString(R.string.INTERVIEW_2_SUMMARY));
                    interviewFold2.setImageResource(R.drawable.fold_down_red);
                }
                break;

            case R.id.interview_fold_3 :
                if(!interviewClicked3) {
                    interviewClicked3 = true;
                    interview3.setText(getResources().getString(R.string.INTERVIEW_3_DETAIL));
                    interviewFold3.setImageResource(R.drawable.fold_up_red);

                } else {
                    interviewClicked3 = false;
                    interview3.setText(getResources().getString(R.string.INTERVIEW_3_SUMMARY));
                    interviewFold3.setImageResource(R.drawable.fold_down_red);
                }
                break;

            case R.id.btnChallenge :
                break;
        }
    }
}
