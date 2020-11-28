package net.awesomekorean.podo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.io.Serializable;

public class AdsManager {

    private String ADMOB_APP_ID = "ca-app-pub-7371634469098812~7867291008";
    private String ADMOB_TEST_ID_FULL_SCREEN = "ca-app-pub-3940256099942544/1033173712";
    private String ADMOB_TEST_ID_REWARDED = "ca-app-pub-3940256099942544/5224354917";
    private String ADMOB_TEST_ID_NATIVE = "ca-app-pub-3940256099942544/2247696110";

    private String ADMOB_ID_FULL_SCREEN = "ca-app-pub-7371634469098812/6205713214";
    private String ADMOB_ID_REWARDED = "ca-app-pub-7371634469098812/2074896515";
    private String ADMOB_ID_NATIVE = "ca-app-pub-7371634469098812/4870095522";

    public InterstitialAd interstitialAd;
    public RewardedAd rewardedAd;

    private static AdsManager instance = new AdsManager();
    public static AdsManager getInstance() {
        return instance;
    }


    // 전면광고 로드
    public void loadFullAds(Context context) {
        interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId(BuildConfig.ADMOB_FULL_ID);
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                System.out.println("전면 광고 로드에 성공했습니다.");
            }

            @Override
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                System.out.println("보상형 광고 로드에 실패했습니다.");
            }

            @Override
            public void onAdClosed() {
                interstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }


    // 전면광고 재생
    public void playFullAds(Context context) {
        UserInformation userInformation = SharedPreferencesInfo.getUserInfo(context);
        int isChallenger = userInformation.getIsChallenger();

        if(isChallenger == 0) {
            if (interstitialAd != null && interstitialAd.isLoaded()) {
                interstitialAd.show();
                System.out.println("전면 광고를 재생합니다.");

                // analytics 로그 이벤트 얻기
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context.getApplicationContext());
                Bundle bundle = new Bundle();
                firebaseAnalytics.logEvent("full_watch", bundle);

            } else {
                System.out.println("The interstitial ads wasn't loaded yet.");
            }

        } else {
            System.out.println("포도챌린저입니다. 광고를 재생하지 않습니다.");
        }
    }


    // 리워드 광고 로드하기
    public void loadRewardAds(Context context) {
        rewardedAd = new RewardedAd(context, BuildConfig.ADMOB_REWARD_ID);
        RewardedAdLoadCallback adLoadCallback = new RewardedAdLoadCallback() {

            @Override
            public void onRewardedAdLoaded() {
                System.out.println("보상형 광고 로드에 성공했습니다");
            }

            @Override
            public void onRewardedAdFailedToLoad(LoadAdError loadAdError) {
                System.out.println("보상형 광고 로드에 실패했습니다.");
            }
        };
        rewardedAd.loadAd(new AdRequest.Builder().build(), adLoadCallback);
    }




    // 리워드 광고 재생
    public void playRewardAds(final Activity activity) {
        if(rewardedAd != null && rewardedAd.isLoaded()) {
            RewardedAdCallback adCallback = new RewardedAdCallback() {

                @Override
                public void onRewardedAdOpened() {
                }

                @Override
                public void onRewardedAdClosed() {
                    loadRewardAds(activity);
                }

                @Override
                public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                    Intent intent = new Intent(activity, GetRandomPoint.class);
                    activity.startActivity(intent);
                    loadRewardAds(activity);

                    // analytics 로그 이벤트 얻기
                    FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(activity);
                    Bundle bundle = new Bundle();
                    firebaseAnalytics.logEvent("reward_watch", bundle);
                }

                @Override
                public void onRewardedAdFailedToShow(AdError adError) {
                    String errCode = String.valueOf(adError.getCode());
                    Toast.makeText(activity, "Failed to play ad. Please try it again. errCode: " + errCode, Toast.LENGTH_LONG).show();
                }
            };
            rewardedAd.show(activity, adCallback);

        } else {
            Toast.makeText(activity, "Failed to load ad. Please try it again.", Toast.LENGTH_LONG).show();
            loadRewardAds(activity);
        }
    }
}
