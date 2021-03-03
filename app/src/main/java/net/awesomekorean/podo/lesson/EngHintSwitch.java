package net.awesomekorean.podo.lesson;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import net.awesomekorean.podo.SharedPreferencesInfo;

import java.util.ArrayList;

public class EngHintSwitch implements CompoundButton.OnCheckedChangeListener {

    private boolean engHint;
    private Context context;
    private ArrayList<TextView> textList;

    EngHintSwitch(Context context, Switch engSwitch, TextView[] textList) {
        this.context = context;
        this.textList = new ArrayList<>();
        for (TextView textView : textList) {
            this.textList.add(textView);
        }
        this.engHint = SharedPreferencesInfo.getEngHint(context);
        setEngHint();
        engSwitch.setChecked(engHint);
        engSwitch.setChecked(this.engHint);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked) {
            engHint = true;

        } else {
            engHint = false;
        }
        SharedPreferencesInfo.setEngHint(context, engHint);
        setEngHint();
    }


    // 영어 표기 세팅
    public void setEngHint() {
        int visible;

        if(engHint) {
            visible = View.VISIBLE;
        } else {
            visible = View.INVISIBLE;
        }

        for (TextView textView : textList) {
            textView.setVisibility(visible);
        }
    }
}
