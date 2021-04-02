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


    // 유저 데이터
    public static void setUserInfo(Context context, UserInformation userInformation) {
        String stringToSP = gson.toJson(userInformation, UserInformation.class);
        SharedPreferences sp = context.getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("info", stringToSP);
        editor.commit();
    }
    public static UserInformation getUserInfo(Context context) {
        SharedPreferences sp = context.getSharedPreferences("user", MODE_PRIVATE);
        String stringFromSP = sp.getString("info", null);
        UserInformation userInformation = gson.fromJson(stringFromSP, UserInformation.class);
        return userInformation;
    }


    // 유저 이메일
    public static String getUserEmail(Context context) {
        String result = getString(context, "userEmail");
        return result;
    }
    public static void setUserEmail(Context context, String userEmail) {
        setString(context, "userEmail", userEmail);
    }


    // 유저 이름
    public static String getUserName(Context context) {
        String result = getString(context, "userName");
        return result;
    }
    public static void setUserName(Context context, String userName) {
        setString(context, "userName", userName);
    }


    // 유저 토큰
    public static String getUserToken(Context context) {
        String result = getString(context, "userToken");
        return result;
    }
    public static void setUserToken(Context context, String userToken) {
        setString(context, "userToken", userToken);
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


    // 마지막으로 클릭한 레슨 레벨
    public static void setLastClickLevel(Context context, int level) { // 0:초급, 1:중급, 2:고급
        setInt(context, "lastClickedLevel", level);
    }
    public static int getLastClickLevel(Context context) {
        int result = getInt(context, "lastClickedLevel");
        return result;
    }


    // 이벤트 타이머
    public static SharedPreferences getEventTimer(Context context) {
        SharedPreferences sp = context.getSharedPreferences("eventTimer", MODE_PRIVATE);
        return sp;
    }
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


    // LessonQuiz1 EngHint
    public static void setEngHint(Context context, boolean b) {
        setBoolean(context, "engHint", b);
    }
    public static boolean getEngHint(Context context) {
        boolean result = getBoolean(context, "engHint");
        return result;
    }


    // 챌린저 할인 이벤트 대상여부
    public static void setChallengerDiscountAvailable(Context context, boolean b) {
        setBoolean(context, "challengerDiscountAvailable", b);
    }
    public static boolean getChallengerDiscountAvailable(Context context) {
        boolean result = getBoolean(context, "challengerDiscountAvailable");
        return result;
    }


    public static void setString(Context context, String name, String string) {
        SharedPreferences sp = context.getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(name, string);
        editor.commit();
    }

    public static String getString(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, MODE_PRIVATE);
        String result = sp.getString(name, null);
        return result;
    }

    public static void setInt(Context context, String name, int number) {
        SharedPreferences sp = context.getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(name, number);
        editor.commit();
        System.out.println(name + "을/를 저장했습니다: " + number);
    }


    public static int getInt(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, MODE_PRIVATE);
        int result = sp.getInt(name, 0);
        System.out.println(name + "을/를 불러옵니다: " + result);
        return result;
    }


    public static void setBoolean(Context context, String name, boolean b) {
        SharedPreferences sp = context.getSharedPreferences(name, MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(name, b);
        editor.commit();
        System.out.println(name +"을/를 저장했습니다: " + b);
    }

    public static boolean getBoolean(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, MODE_PRIVATE);
        boolean result = sp.getBoolean(name, false);
        System.out.println(name + "을/를 불러옵니다: " + result);
        return result;
    }
}
