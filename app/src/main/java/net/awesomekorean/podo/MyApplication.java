package net.awesomekorean.podo;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MyApplication extends Application {

    private AdsManager adsManager;
    private OpenAdsManager openAdsManager;

    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                System.out.println("애드몹을 초기화했습니다");
                // 광고 미리 로드하기
                adsManager = AdsManager.getInstance();
                adsManager.loadFullAds(getApplicationContext());
                adsManager.loadRewardAds(getApplicationContext());
            }
        });

        UserInformation userInformation = SharedPreferencesInfo.getUserInfo(getApplicationContext());
        if(userInformation != null && userInformation.getIsChallenger() == 0) {
            openAdsManager = new OpenAdsManager(this);
        }
    }
}
