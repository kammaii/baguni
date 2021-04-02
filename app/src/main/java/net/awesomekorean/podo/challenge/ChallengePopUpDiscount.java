package net.awesomekorean.podo.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;

public class ChallengePopUpDiscount extends AppCompatActivity {

    Button btnGet;
    private final String DISCOUNT = "discount";
    private final int PERCENT = 20;
    private final int TIME = 60;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_pop_up_discount);

        btnGet = findViewById(R.id.btnGet);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Challenge.class);
                intent.putExtra(DISCOUNT, PERCENT);
                startActivity(intent);
                setResult(RESULT_OK);
                finish();
            }
        });

        long eventTime = TIME * 60;
        SharedPreferencesInfo.setEventTimer(getApplicationContext(), eventTime, PERCENT);
        SharedPreferencesInfo.setChallengerDiscountAvailable(getApplicationContext(), false);
    }
}