package net.awesomekorean.podo.purchase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import net.awesomekorean.podo.MainActivity;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SettingStatusBar;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UnixTimeStamp;
import net.awesomekorean.podo.UserInformation;

import java.util.ArrayList;
import java.util.List;

public class TopUp extends AppCompatActivity implements View.OnClickListener, PurchasesUpdatedListener {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    ImageView btnClose;

    LinearLayout pointA;
    LinearLayout pointB;
    LinearLayout pointC;

    ImageView checkPointA;
    ImageView checkPointB;
    ImageView checkPointC;

    Button btnGetPoint;

    FirebaseAnalytics firebaseAnalytics;

    BillingClient billingClient;
    SkuDetails skuDetails;
    SkuDetails skuDetails100;
    SkuDetails skuDetails500;
    SkuDetails skuDetails1000;

    TextView price100;
    TextView price500;
    TextView price1000;

    Bundle params;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        SettingStatusBar.setStatusBar(this);

        btnClose = findViewById(R.id.btnClose);
        pointA = findViewById(R.id.pointA);
        pointB = findViewById(R.id.pointB);
        pointC = findViewById(R.id.pointC);
        checkPointA = findViewById(R.id.checkPointA);
        checkPointB = findViewById(R.id.checkPointB);
        checkPointC = findViewById(R.id.checkPointC);
        btnGetPoint = findViewById(R.id.btnGetPoint);
        price100 = findViewById(R.id.price100);
        price500 = findViewById(R.id.price500);
        price1000 = findViewById(R.id.price1000);
        btnClose.setOnClickListener(this);
        pointA.setOnClickListener(this);
        pointB.setOnClickListener(this);
        pointC.setOnClickListener(this);
        btnGetPoint.setOnClickListener(this);

        // analytics 로그 이벤트 얻기
        params = new Bundle();
        firebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());
        firebaseAnalytics.logEvent("topUp_open", params);

        setPurchase(pointB, checkPointB, getString(R.string.SKU_1000));


        billingClient = BillingClient.newBuilder(getApplicationContext())
                .enablePendingPurchases()
                .setListener(this).build();


        // 구글플레이에 연결하기
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {

                // 구글플레이와 연결 성공
                if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    System.out.println("구글플레이와 연결을 성공했습니다.");
                    getSkuDetail();

                } else {
                    System.out.println("구글플레이와 연결을 실패했습니다. : " + billingResult.getDebugMessage());
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
                System.out.println("구글플레이와 연결이 끊어졌습니다.");
            }
        });
    }


    // 상품 정보 받아오기
    public void getSkuDetail() {
        List<String> skuList = new ArrayList<>();
        skuList.add(getString(R.string.SKU_100));
        skuList.add(getString(R.string.SKU_500));
        skuList.add(getString(R.string.SKU_1000));

        SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
        params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP);
        billingClient.querySkuDetailsAsync(params.build(), new SkuDetailsResponseListener() {
            @Override
            public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {

                if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    System.out.println("챌린지 상품 정보를 받았습니다.");
                    for(SkuDetails sku : list) {
                        if(sku.getSku().equals(getString(R.string.SKU_100))) {
                            price100.setText(sku.getPrice());
                            skuDetails100 = sku;
                        } else if(sku.getSku().equals(getString(R.string.SKU_500))) {
                            price500.setText(sku.getPrice());
                            skuDetails500 = sku;
                        } else {
                            price1000.setText(sku.getPrice());
                            skuDetails1000 = sku;
                            skuDetails = sku;
                        }
                    }

                } else {
                    System.out.println("챌린지 상품 정보 받아오기를 실패했습니다. : " + billingResult.getDebugMessage());
                }
            }
        });
    }


    // 결제 처리
    @Override
    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> list) {

        // 결제 성공
        if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK && list != null) {
            System.out.println("결제를 성공했습니다.");
            final UserInformation userInformation = SharedPreferencesInfo.getUserInfo(getApplicationContext());
            int havePoint = userInformation.getPoints();
            int newPoint;
            int purchasePoint = 0;

            for (Purchase purchase : list) {
                if(purchase.getSku().equals(getString(R.string.SKU_100))) {
                    purchasePoint = 100;
                } else if(purchase.getSku().equals(getString(R.string.SKU_500))) {
                    purchasePoint = 500;
                } else {
                    purchasePoint = 1000;
                }
            }

            newPoint = havePoint + purchasePoint;

            userInformation.setPoints(newPoint);
            userInformation.setPointsPurchased(purchasePoint);

            SharedPreferencesInfo.setUserInfo(getApplicationContext(), userInformation);

            db.collection(getString(R.string.DB_USERS)).document(MainActivity.userEmail)
                    .update(
                            "points", userInformation.getPoints(),
                            "pointsPurchased", userInformation.getPointsPurchased()
                    )
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            System.out.println("DB에 구매한 포인트 저장을 성공했습니다.");
                            Toast.makeText(getApplicationContext(), getString(R.string.THANKS_PURCHASING), Toast.LENGTH_LONG).show();
                            FirebaseMessaging.getInstance().subscribeToTopic("purchase_point");

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    System.out.println("DB에 구매한 포인트 저장을 실패했습니다.: " +  e);
                    Toast.makeText(getApplicationContext(), getString(R.string.ERROR_PURCHASING) + e, Toast.LENGTH_LONG).show();
                }
            });

            params.putInt("purchasePoint", purchasePoint);
            firebaseAnalytics.logEvent("topUp_purchase", params);


            // 상품 소모하기
            ConsumeResponseListener consumeListener = new ConsumeResponseListener() {
                @Override
                public void onConsumeResponse(BillingResult billingResult, String s) {

                    if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                        System.out.println("상품을 성공적으로 소모하였습니다.");
                    } else {
                        System.out.println("상품 소모를 실패했습니다. : " + billingResult.getResponseCode());
                    }
                }
            };

            ConsumeParams consumeParams = ConsumeParams.newBuilder()
                    .setPurchaseToken(list.get(0).getPurchaseToken()).build();

            billingClient.consumeAsync(consumeParams, consumeListener);

            finish();


            // 결제 취소
        } else if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
            System.out.println("결제를 취소했습니다.");
            firebaseAnalytics.logEvent("topUp_cancel", params);


            //결제 실패
        } else {
            System.out.println("결제를 실패했습니다. : " + billingResult.getResponseCode());
            firebaseAnalytics.logEvent("topUp_fail", params);
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btnClose :
                finish();
                firebaseAnalytics.logEvent("topUp_close", params);
                break;

            case R.id.pointA :
                setPurchase(pointA, checkPointA, getString(R.string.SKU_100));
                break;

            case R.id.pointB :
                setPurchase(pointB, checkPointB, getString(R.string.SKU_1000));
                break;

            case R.id.pointC :
                setPurchase(pointC, checkPointC, getString(R.string.SKU_500));
                break;

            case R.id.btnGetPoint :
                BillingFlowParams flowParams = BillingFlowParams.newBuilder().setSkuDetails(skuDetails).build();
                billingClient.launchBillingFlow(this, flowParams);
                break;
        }
    }


    private void setPurchase(LinearLayout purchase, ImageView check, String id) {

        if(id.equals(getString(R.string.SKU_100))) {
            skuDetails = skuDetails100;
        } else if (id.equals(getString(R.string.SKU_500))) {
            skuDetails = skuDetails500;
        } else {
            skuDetails = skuDetails1000;
        }

        pointA.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_grey_10));
        pointB.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_grey_10));
        pointC.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_grey_10));

        checkPointA.setVisibility(View.GONE);
        checkPointB.setVisibility(View.GONE);
        checkPointC.setVisibility(View.GONE);

        purchase.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_grey_10_stroke_navy));
        check.setVisibility(View.VISIBLE);
    }
}
