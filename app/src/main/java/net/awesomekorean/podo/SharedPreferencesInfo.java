package net.awesomekorean.podo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesInfo {

    static Gson gson = new GsonBuilder().create();


    // 앱에 유저 데이터 저장하기
    public static void setUserInfo(Context context, UserInformation userInformation) {
        String stringToSP = gson.toJson(userInformation, UserInformation.class);
        SharedPreferences sp = context.getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("info", stringToSP);
        editor.commit();
    }

    // 엡에서 유저 데이터 불러오기
    public static UserInformation getUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("user", MODE_PRIVATE);
        String stringFromSP = sp.getString("info", null);
        UserInformation userInformation = gson.fromJson(stringFromSP, UserInformation.class);
        return userInformation;
    }

    // 엡에서 유저 이메일 불러오기
    public static String getUserEmail(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userEmail", MODE_PRIVATE);
        String stringFromSP = sp.getString("userEmail", null);
        return stringFromSP;
    }

    // 엡에 유저 이메일 저장하기
    public static void setUserEmail(Context context, String userEmail) {
        SharedPreferences sp = context.getSharedPreferences("userEmail", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userEmail", userEmail);
        editor.commit();
    }

    // 엡에서 유저 이름 불러오기
    public static String getUserName(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userName", MODE_PRIVATE);
        String stringFromSP = sp.getString("userName", null);
        return stringFromSP;
    }

    // 엡에 유저 이름 저장하기
    public static void setUserName(Context context, String userName) {
        SharedPreferences sp = context.getSharedPreferences("userName", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userName", userName);
        editor.commit();
    }

    // 엡에서 유저 토큰 불러오기
    public static String getUserToken(Context context) {
        SharedPreferences sp = context.getSharedPreferences("userToken", MODE_PRIVATE);
        String stringFromSP = sp.getString("userToken", null);
        return stringFromSP;
    }

    // 엡에 유저 토큰 저장하기
    public static void setUserToken(Context context, String userToken) {
        SharedPreferences sp = context.getSharedPreferences("userToken", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("userToken", userToken);
        editor.commit();
    }


    // Lesson 이랑 Reading 에서 마지막으로 클릭한 위치 저장하기
    public static void setLastClickItem(Context context, boolean isLesson, int pos) {
        SharedPreferences sp = context.getSharedPreferences("lastClickedItem", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if(isLesson) { // 레슨위치 저장
            editor.putInt("lesson", pos);
        } else {
            editor.putInt("reading", pos);
        }
        editor.commit();
        System.out.println("클릭 위치를 저장했습니다: "+pos);
    }

    public static int getLastClickItem(Context context, boolean isLesson) {
        SharedPreferences sp = context.getSharedPreferences("lastClickedItem", MODE_PRIVATE);
        int lastPos;
        if(isLesson) {
            lastPos = sp.getInt("lesson", 0);
        } else {
            lastPos = sp.getInt("reading", 0);
        }
        System.out.println("클릭 위치를 불러옵니다: "+lastPos);
        return lastPos;
    }


    // 마지막으로 클릭한 레슨 레벨 저장하기
    public static void setLastClickLevel(Context context, int level) { // 0:초급, 1:중급, 2:고급
        SharedPreferences sp = context.getSharedPreferences("lastClickedLevel", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("level", level);
        editor.commit();
        System.out.println("클릭 레벨을 저장했습니다: "+level);
    }

    public static int getLastClickLevel(Context context) {
        SharedPreferences sp = context.getSharedPreferences("lastClickedLevel", MODE_PRIVATE);
        int level = sp.getInt("level", 0);
        System.out.println("클릭 레벨을 불러옵니다: "+level);
        return level;
    }

    // 타이머 불러오기
    public static SharedPreferences getEventTimer(Context context) {
        SharedPreferences sp = context.getSharedPreferences("eventTimer", MODE_PRIVATE);
        return sp;
    }

    // 타이머 저장하기
    public static void setEventTimer(Context context, long eventTime, int percent) {
        SharedPreferences sp = context.getSharedPreferences("eventTimer", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if(eventTime != 0) {
            editor.putBoolean("isWorking", true);
            editor.putLong("startTime", UnixTimeStamp.getTimeNow());
            editor.putLong("eventTime", eventTime);
            editor.putInt("percent", percent);

        } else {
            editor.putBoolean("isWorking", false);
            editor.putLong("startTime", 0);
            editor.putLong("eventTime", 0);
            editor.putInt("percent", 0);
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
            Bundle bundle = new Bundle();
            firebaseAnalytics.logEvent("eventTimer_finished", bundle);
        }

        editor.commit();
    }


    // LessonQuiz1 EngHint 저장하기
    public static void setEngHint(Context context, boolean b) {
        SharedPreferences sp = context.getSharedPreferences("engHint", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("engHint", b);
        editor.commit();
        System.out.println("EngHint 를 저장했습니다: "+b);
    }

    public static boolean getEngHint(Context context) {
        SharedPreferences sp = context.getSharedPreferences("engHint", MODE_PRIVATE);
        boolean engHint = sp.getBoolean("engHint", false);
        System.out.println("EngHint 를 불러옵니다: "+engHint);
        return engHint;
    }
}
