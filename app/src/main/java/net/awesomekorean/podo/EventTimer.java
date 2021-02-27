package net.awesomekorean.podo;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

public class EventTimer extends CountDownTimer {

    private Context context;
    private long eventTime;
    private TextView textView;

    public EventTimer(Context context, long eventTime, TextView textView) {
        super(eventTime * 1000, 1000);
        this.context = context;
        this.eventTime = eventTime;
        this.textView = textView;
        this.start();
    }

    @Override
    public void onTick(long l) {
        System.out.println("타이머 작동중 : " + l/1000 + "초 / " + eventTime);
        textView.setText("타이머 작동중 : " + l/1000);
    }

    @Override
    public void onFinish() {
        System.out.println("타이머 종료");
        this.cancel();
        SharedPreferencesInfo.setEventTimer(context, 0);
    }
}
