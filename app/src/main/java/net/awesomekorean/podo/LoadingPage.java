package net.awesomekorean.podo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LoadingPage extends AppCompatActivity {

    public static Activity activity;

    public static TextView textLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_page);

        textLoading = findViewById(R.id.textLoading);

        activity = LoadingPage.this;
    }

    public void setTextLoading(int progress, int max) {
        textLoading.setText("Loading... " + "(" + progress*100/max + "%)");
    }
}
