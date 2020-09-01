package net.awesomekorean.podo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;

import net.awesomekorean.podo.login.SignIn;

public class Logo extends AppCompatActivity {


    private FirebaseAnalytics firebaseAnalytics;
    private FirebaseCrashlytics crashlytics;
    private AdsManager adsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);

        // Crashlytics 초기화
        crashlytics = FirebaseCrashlytics.getInstance();
        crashlytics.setCrashlyticsCollectionEnabled(false);

        // 애널리스트 초기화
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        firebaseAnalytics.setAnalyticsCollectionEnabled(false);

        // 애드몹 초기화
        MobileAds.initialize(this, getString(R.string.ADMOB_APP_ID));

        // 광고 미리 로드하기
        adsManager = AdsManager.getInstance();
        adsManager.loadFullAds(this);
        adsManager.loadRewardAds(this);
        adsManager.loadNativeAds(this);

        // 기기 토큰 얻기
        String token = SharedPreferencesInfo.getUserToken(getApplicationContext());
        if(token == null) {
            FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                @Override
                public void onComplete(@NonNull Task<InstanceIdResult> task) {
                    if (task.isSuccessful()) {
                        String token = task.getResult().getToken();
                        SharedPreferencesInfo.setUserToken(getApplicationContext(), token);
                        System.out.println("토큰을 저장했습니다 : " + token);
                    }
                }
            });
        } else {
            System.out.println("토큰 : " + token);
        }


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent;

                boolean isSignIn = SharedPreferencesInfo.getSignIn(getApplicationContext());
                if(isSignIn) {
                    if(IsOnline.isOnline(getApplicationContext())) {
                        intent = new Intent(getApplicationContext(), MainActivity.class);

                        // 재접속 로그
                        Bundle bundle = new Bundle();
                        firebaseAnalytics.logEvent("revisit", bundle);

                    } else {
                        intent = new Intent(getApplicationContext(), SignIn.class);
                        Toast.makeText(getApplicationContext(), "Internet connection required.", Toast.LENGTH_LONG).show();
                    }
                } else {
                    intent = new Intent(getApplicationContext(), SignIn.class);
                }
                startActivity(intent);
                finish();
            }
        }, 2);

    }

}
