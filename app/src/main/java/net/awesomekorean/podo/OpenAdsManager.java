package net.awesomekorean.podo;

import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;

import java.util.Date;

import static androidx.lifecycle.Lifecycle.Event.ON_START;

public class OpenAdsManager implements LifecycleObserver, Application.ActivityLifecycleCallbacks {

    private AppOpenAd appOpenAd = null;
    private final MyApplication myApplication;
    private Activity currentActivity;
    private static boolean isShowingAd = false;
    private long loadTime = 0;

    public OpenAdsManager(MyApplication myApplication) {
        this.myApplication = myApplication;
        this.myApplication.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(ON_START)
    public void onStart() {
        System.out.println("오픈광고 : onStart");
        showAdIfAvailable();
    }

    // 오픈광고 로드
    public void fetchAd() {
        System.out.println("오픈광고 로딩을 시도합니다.");

        AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
            @Override
            public void onAppOpenAdLoaded(AppOpenAd appOpenAd) {
                OpenAdsManager.this.appOpenAd = appOpenAd;
                OpenAdsManager.this.loadTime = (new Date()).getTime();
                System.out.println("오픈광고가 로드되었습니다.");
            }

            @Override
            public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
                System.out.println("오픈광고 로드를 실패했습니다. : " + loadAdError.getMessage());
            }
        };

        AdRequest request = new AdRequest.Builder().build();
        AppOpenAd.load(myApplication, BuildConfig.ADMOB_OPEN_ID, request, AppOpenAd.APP_OPEN_AD_ORIENTATION_PORTRAIT, loadCallback);
    }


    private boolean wasLoadTimeLessThanNHoursAgo(long numHours) {
        long dateDifference = (new Date()).getTime() - this.loadTime;
        long numMilliSecondsPerHour = 3600000;
        return (dateDifference < (numMilliSecondsPerHour * numHours));
    }


    public boolean isAdAvailable() {
        return appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4);
    }


    // 오픈광고 재생
    public void showAdIfAvailable() {
        System.out.println("이즈쇼잉 : " + isShowingAd);
        System.out.println("이즈어베일러블 : " + isAdAvailable());

        if(!isShowingAd && isAdAvailable()) {
            System.out.println("오픈광고를 재생합니다.");

            FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    OpenAdsManager.this.appOpenAd = null;
                    isShowingAd = false;
                    fetchAd();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(AdError adError) {
                    System.out.println("오픈광고가 재생을 실패했습니다. : " + adError.getMessage());
                }

                @Override
                public void onAdShowedFullScreenContent() {
                    isShowingAd = true;
                }
            };

            appOpenAd.show(currentActivity, fullScreenContentCallback);

        } else {
            System.out.println("오픈광고를 재생할 수 없습니다.");
            fetchAd();
        }
    }


    // 액티비티 라이프사이클 콜백
    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        System.out.println("오픈광고 : activityCreated");
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        System.out.println("오픈광고 : activityStarted");
        currentActivity = activity;
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
        System.out.println("오픈광고 : activityResumed");
        currentActivity = activity;
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
        System.out.println("오픈광고 : activityPaused");
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
        System.out.println("오픈광고 : activityStopped");
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
        System.out.println("오픈광고 : activitySaveInstanceState");
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
        System.out.println("오픈광고 : activityDestroyed");
        currentActivity = null;
    }
}
