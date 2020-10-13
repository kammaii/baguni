package net.awesomekorean.podo.reading;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.firestore.FirebaseFirestore;

import net.awesomekorean.podo.MainActivity;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UnitProgressInfo;
import net.awesomekorean.podo.UnlockActivity;
import net.awesomekorean.podo.UserInformation;
import net.awesomekorean.podo.reading.readings.Reading08;
import net.awesomekorean.podo.reading.readings.Reading01;
import net.awesomekorean.podo.reading.readings.Reading02;
import net.awesomekorean.podo.reading.readings.Reading03;
import net.awesomekorean.podo.reading.readings.Reading04;
import net.awesomekorean.podo.reading.readings.Reading05;
import net.awesomekorean.podo.reading.readings.Reading06;
import net.awesomekorean.podo.reading.readings.Reading07;
import net.awesomekorean.podo.reading.readings.Reading00;
import net.awesomekorean.podo.reading.readings.Reading09;
import net.awesomekorean.podo.reading.readings.Reading10;
import net.awesomekorean.podo.reading.readings.Reading11;
import net.awesomekorean.podo.reading.readings.Reading12;
import net.awesomekorean.podo.reading.readings.Reading13;
import net.awesomekorean.podo.reading.readings.Reading14;
import net.awesomekorean.podo.reading.readings.Reading15;
import net.awesomekorean.podo.reading.readings.Reading16;
import net.awesomekorean.podo.reading.readings.Reading17;
import net.awesomekorean.podo.reading.readings.Reading18;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;
import static net.awesomekorean.podo.MainActivity.btnReading;
import static net.awesomekorean.podo.MainActivity.textReading;

public class MainReading extends Fragment {

    Reading readingUnit;

    Context context;

    View view;

    Intent intent;

    ArrayList<Reading> list;
    ReadingAdapter adapter;

    UserInformation userInformation;

    Button btnGetReading;
    boolean isClicked;  // 읽기 구매리스트 전환 버튼

    Reading[] items = {
            new Reading00(), new Reading01(), new Reading02(), new Reading03(), new Reading04(), new Reading05(), new Reading06(), new Reading07(), new Reading08(), new Reading09(), new Reading10(), new Reading11(), new Reading12(), new Reading13(), new Reading14(), new Reading15(), new Reading16(), new Reading17(), new Reading18()
    };


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_reading, container, false);
        context = getContext();
        userInformation = SharedPreferencesInfo.getUserInfo(context);
        list = new ArrayList<>();
        isClicked = false;

        items[0].setIsLocked(false);
        items[1].setIsLocked(false);

        setCompletedReadings();
        setUnlockedReadings();

        for(Reading item : items) {
            if(!item.getIsLock()) {
                list.add(item);
            }
        }

        adapter = new ReadingAdapter(getContext(), list);
        adapter.setOnItemClickListener(new ReadingAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                readingUnit = list.get(pos);
                FirebaseCrashlytics.getInstance().setCustomKey("readingId", readingUnit.getReadingId());

                if(!readingUnit.getIsLock()) {
                    intent = new Intent(context, ReadingFrame.class);

                } else {
                    // 포인트 사용 확인창 띄우기
                    intent = new Intent(context, UnlockActivity.class);
                    intent.putExtra(getResources().getString(R.string.EXTRA_ID), getResources().getString(R.string.READING));
                }

                intent.putExtra(getResources().getString(R.string.READING), (Serializable) readingUnit);
                startActivity(intent);
            }
        });

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        btnGetReading = view.findViewById(R.id.btnGetReading);
        btnGetReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();

                if(!isClicked) {
                    for(Reading item : items) {
                        if(item.getIsLock()) {
                            list.add(item);
                        }
                    }
                    btnGetReading.setText(getText(R.string.GO_BACK_MY_READING));
                    btnGetReading.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_white_30_stroke_purple));
                    btnGetReading.setTextColor(ContextCompat.getColorStateList(context, R.color.PURPLE));
                    isClicked = true;

                } else {
                    for(Reading item : items) {
                        if(!item.getIsLock()) {
                            list.add(item);
                        }
                    }
                    btnGetReading.setText(getText(R.string.GET_MORE_READING));
                    btnGetReading.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_purple_30));
                    btnGetReading.setTextColor(ContextCompat.getColorStateList(context, R.color.WHITE));
                    isClicked = false;
                }
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }


    // 읽기 진도율 세팅하기
    private void setCompletedReadings() {
        List<String> readingComplete = userInformation.getReadingComplete();
        System.out.println("READING_COMPLETE:" + readingComplete);

        if(readingComplete != null) {

            for(int i=0; i<items.length; i++) {
                String readingId = items[i].getReadingId();

                if(readingComplete.contains(readingId)) {
                    items[i].setIsCompleted(true);
                } else {
                    items[i].setIsCompleted(false);
                }
            }
        }
    }


    // 구매된 읽기 세팅하기
    private void setUnlockedReadings() {
        List<String> readingUnlock = userInformation.getReadingUnlock();
        System.out.println("READING_UNLOCK:" + readingUnlock);

        if(readingUnlock != null) {
            for(int i=0; i<items.length; i++) {
                if(readingUnlock.contains(items[i].getReadingId())) {
                    items[i].setIsLocked(false);
                }
            }
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        userInformation = SharedPreferencesInfo.getUserInfo(context);

        if(adapter != null) {
            setCompletedReadings();
            setUnlockedReadings();
            isClicked = true;
            btnGetReading.performClick();
            adapter.notifyDataSetChanged();
        }
    }
}


