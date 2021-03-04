package net.awesomekorean.podo;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class EventTimer extends CountDownTimer {

    private Context context;
    private long eventTime;
    private TextView textView;
    private Intent intent;
    private final String DISCOUNT = "discount";


    public EventTimer(Context context, long eventTime, TextView textView, Intent intent) {
        super(eventTime * 1000, 1000);
        this.context = context;
        this.eventTime = eventTime;
        this.textView = textView;
        this.intent = intent;
        this.start();
    }

    @Override
    public void onTick(long l) {
        System.out.println("타이머 작동중 : " + l/1000 + "초 / " + eventTime);
        int totalSec, hour, min, sec;
        totalSec = (int) l/1000;
        hour = totalSec/3600;
        min = (totalSec - (hour * 3600)) / 60;
        sec = (totalSec - (hour * 3600) - (min * 60));
        textView.setText(String.format("%02d", hour) + " : " + String.format("%02d", min) + " : " + String.format("%02d", sec));
    }

    @Override
    public void onFinish() {
        System.out.println("타이머 종료");
        this.cancel();
        intent.removeExtra(DISCOUNT);
        textView.setVisibility(View.GONE);
        SharedPreferencesInfo.setEventTimer(context, 0, 0);
    }
}
