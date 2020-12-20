package net.awesomekorean.podo.challenge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import net.awesomekorean.podo.MainActivity;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UnixTimeStamp;
import net.awesomekorean.podo.UserInformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.relex.circleindicator.CircleIndicator;

public class Challenge extends AppCompatActivity implements View.OnClickListener, PurchasesUpdatedListener {

    FirebaseAnalytics firebaseAnalytics;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    FragmentPagerAdapter adapter;
    ArrayList<Integer> imageList;

    ImageView btnBack;
    TextView interview1;
    TextView interview2;
    TextView interview3;
    ImageView interviewFold1;
    ImageView interviewFold2;
    ImageView interviewFold3;
    ConstraintLayout btnChallenge;
    TextView textChallenge;

    boolean interviewClicked1 = false;
    boolean interviewClicked2 = false;
    boolean interviewClicked3 = false;

    BillingClient billingClient;
    SkuDetails skuDetails;


    int discount = 0;
    private final String DISCOUNT = "discount";
    ImageView discountTape;
    TextView discountPercent;
    TextView priceOriginal;
    TextView price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        btnBack = findViewById(R.id.btnBack);
        interview1 = findViewById(R.id.interview_1);
        interview2 = findViewById(R.id.interview_2);
        interview3 = findViewById(R.id.interview_3);
        interviewFold1 = findViewById(R.id.interview_fold_1);
        interviewFold2 = findViewById(R.id.interview_fold_2);
        interviewFold3 = findViewById(R.id.interview_fold_3);
        btnChallenge = findViewById(R.id.btnChallenge);
        textChallenge = findViewById(R.id.textChallenge);
        discountTape = findViewById(R.id.discountTape);
        discountPercent = findViewById(R.id.discountPercent);
        priceOriginal = findViewById(R.id.priceOriginal);
        price = findViewById(R.id.price);
        btnBack.setOnClickListener(this);
        interviewFold1.setOnClickListener(this);
        interviewFold2.setOnClickListener(this);
        interviewFold3.setOnClickListener(this);
        btnChallenge.setOnClickListener(this);

        Bundle bundleOpen = new Bundle();
        firebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());
        firebaseAnalytics.logEvent("challenge_open", bundleOpen);
        FirebaseMessaging.getInstance().subscribeToTopic("challenge_page_open");

        discount = getIntent().getIntExtra(DISCOUNT, 0);
        initDiscount();

        imageList = new ArrayList<>();
        imageList.add(R.drawable.benefits_ads);
        imageList.add(R.drawable.benefits_lessons);
        imageList.add(R.drawable.benefits_progress);
        imageList.add(R.drawable.benefits_points);

        ViewPager viewPager = findViewById(R.id.viewPager);
        adapter = new ChallengeAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        Shader shader = new LinearGradient(0,0,100,0, new int[]{ContextCompat.getColor(getApplicationContext(), R.color.PINK2), ContextCompat.getColor(getApplicationContext(), R.color.PURPLE)}, new float[]{0, 1}, Shader.TileMode.CLAMP);
        textChallenge.getPaint().setShader(shader);

        btnChallenge.setEnabled(false);
        btnChallenge.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_grey_light_10));


        billingClient = BillingClient.newBuilder(getApplicationContext())
                .setListener(this)
                .enablePendingPurchases()
                .build();


        // 구글플레이에 연결하기
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {

                // 구글플레이와 연결 성공
                if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    System.out.println("구글플레이와 연결을 성공했습니다.");
                    btnChallenge.setEnabled(true);
                    btnChallenge.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bg_purple_10));
                    getSkuDetail();

                } else {
                    System.out.println("구글플레이와 연결을 실패했습니다. : " + billingResult.getDebugMessage());
                    Bundle bundleConnectionFail = new Bundle();
                    bundleConnectionFail.putInt("responseCode", billingResult.getResponseCode());
                    bundleConnectionFail.putString("message", billingResult.getDebugMessage());
                    firebaseAnalytics.logEvent("challenge_connection_fail", bundleConnectionFail);
                }
            }

            @Override
            public void onBillingServiceDisconnected() {
                System.out.println("구글플레이와 연결이 끊어졌습니다.");
                //todo: 연결 다시 시도하기
            }
        });
    }

    private void initDiscount() {
        discountTape.setVisibility(View.GONE);
        discountPercent.setVisibility(View.GONE);
        priceOriginal.setVisibility(View.GONE);
    }


    // 상품 정보 받아오기
    public void getSkuDetail() {
        List<String> skuList = new ArrayList<>();
        skuList.add(getString(R.string.SKU_CHALLENGER));
        skuList.add(getString(R.string.SKU_CHALLENGER) + "_" + discount);

        SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
        params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP);
        billingClient.querySkuDetailsAsync(params.build(), new SkuDetailsResponseListener() {
            @Override
            public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {

                if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    System.out.println("챌린지 상품 정보를 받았습니다.");
                    System.out.println("리스트 : " + list);

                    for(SkuDetails sku : list) {
                        if(sku.getSku().equals(getString(R.string.SKU_CHALLENGER))) {
                            priceOriginal.setText(sku.getPrice());
                            if(discount == 0) {
                                skuDetails = sku;
                            }
                        } else if(sku.getSku().equals(getString(R.string.SKU_CHALLENGER) + "_" + discount)) {
                            price.setText(sku.getPrice());
                            if(discount != 0) {
                                skuDetails = sku;
                            }
                        }
                    }

                    if(discount != 0) {
                        discountTape.setVisibility(View.VISIBLE);
                        discountPercent.setVisibility(View.VISIBLE);
                        discountPercent.setText(discount + "%");
                        priceOriginal.setPaintFlags(priceOriginal.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
                        priceOriginal.setVisibility(View.VISIBLE);

                    } else {
                        price.setText(skuDetails.getPrice());
                    }

                } else {
                    System.out.println("챌린지 상품 정보 받아오기를 실패했습니다. : " + billingResult.getDebugMessage());
                    Bundle bundleSkuFail = new Bundle();
                    bundleSkuFail.putInt("responseCode", billingResult.getResponseCode());
                    bundleSkuFail.putString("message", billingResult.getDebugMessage());
                    firebaseAnalytics.logEvent("challenge_getSku_fail", bundleSkuFail);
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
            List<String> orderId = new ArrayList<>();
            List<Integer> purchaseState = new ArrayList<>();

            for(Purchase purchase : list) {
                System.out.println("orderId : " + purchase.getOrderId());
                System.out.println("purchaseState : " + purchase.getPurchaseState());
                orderId.add(purchase.getOrderId());
                purchaseState.add(purchase.getPurchaseState());
            }

            UserInformation userInformation = SharedPreferencesInfo.getUserInfo(getApplicationContext());
            Long timeStart = UnixTimeStamp.getTimeNow();
            Long timeExpire = timeStart + 2592000;

            userInformation.setIsChallenger(1);
            userInformation.setDateChallengeStart(timeStart);
            userInformation.setDateChallengeExpire(timeExpire);

            SharedPreferencesInfo.setUserInfo(getApplicationContext(), userInformation);

            db.collection(getString(R.string.DB_USERS)).document(MainActivity.userEmail).set(userInformation).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    System.out.println("챌린지를 구매했습니다.");
                    Toast.makeText(getApplicationContext(), getString(R.string.THANKS_PURCHASING), Toast.LENGTH_LONG).show();
                    FirebaseMessaging.getInstance().subscribeToTopic("purchase_challenge");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    System.out.println("DB에 챌린지정보 저장을 실패했습니다.: " +  e);
                    Toast.makeText(getApplicationContext(), getString(R.string.ERROR_PURCHASING) + e, Toast.LENGTH_LONG).show();
                }
            });


            // todo: 안정화되면 삭제하기
            // 구매기록 대조를 위한 저장
            Map<String, Object> confirmChallenger = new HashMap<>();
            confirmChallenger.put("userEmail", MainActivity.userEmail);
            confirmChallenger.put("orderId", orderId);
            confirmChallenger.put("purchaseState", purchaseState);
            db.collection("android/podo/challenger").add(confirmChallenger).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    System.out.println("구매기록을 저장했습니다.");
                }
            });


            Bundle bundlePurchase = new Bundle();
            firebaseAnalytics.logEvent("challenge_purchase", bundlePurchase);


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

            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();


        // 결제 취소
        } else if(billingResult.getResponseCode() == BillingClient.BillingResponseCode.USER_CANCELED) {
            System.out.println("결제를 취소했습니다.");
            Bundle bundleCancel = new Bundle();
            firebaseAnalytics.logEvent("challenge_cancel", bundleCancel);


        //결제 실패
        } else {
            System.out.println("결제를 실패했습니다. : " + billingResult.getResponseCode());
            Bundle bundleFail = new Bundle();
            bundleFail.putInt("responseCode", billingResult.getResponseCode());
            bundleFail.putString("message", billingResult.getDebugMessage());
            firebaseAnalytics.logEvent("challenge_fail", bundleFail);


            // todo: 안정화 되면 삭제하기
            // 결제 실패 원인 DB에 저장하기
            Map<String, Object> challengeFail = new HashMap<>();
            challengeFail.put("userEmail", MainActivity.userEmail);
            if(skuDetails != null) {
                challengeFail.put("sku", skuDetails.getSku());
                challengeFail.put("skuPrice", skuDetails.getPrice());
            }
            if(list != null) {
                challengeFail.put("orderId", list.get(0).getOrderId());
                challengeFail.put("purchaseState", list.get(0).getPurchaseState());
            }
            challengeFail.put("responseCode", billingResult.getResponseCode());
            challengeFail.put("message", billingResult.getDebugMessage());
            db.collection("android/podo/challengeFail").add(challengeFail).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    System.out.println("결제실패 원인을 저장했습니다.");
                }
            });
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnBack :
                Bundle bundleClose = new Bundle();
                firebaseAnalytics.logEvent("challenge_close", bundleClose);
                finish();
                break;

            case R.id.interview_fold_1 :
                if(!interviewClicked1) {
                    interviewClicked1 = true;
                    interview1.setText(getResources().getString(R.string.INTERVIEW_1_DETAIL));
                    interviewFold1.setImageResource(R.drawable.fold_up_red);
                } else {
                    interviewClicked1 = false;
                    interview1.setText(getResources().getString(R.string.INTERVIEW_1_SUMMARY));
                    interviewFold1.setImageResource(R.drawable.fold_down_red);
                }
                break;

            case R.id.interview_fold_2 :
                if(!interviewClicked2) {
                    interviewClicked2 = true;
                    interview2.setText(getResources().getString(R.string.INTERVIEW_2_DETAIL));
                    interviewFold2.setImageResource(R.drawable.fold_up_red);

                } else {
                    interviewClicked2 = false;
                    interview2.setText(getResources().getString(R.string.INTERVIEW_2_SUMMARY));
                    interviewFold2.setImageResource(R.drawable.fold_down_red);
                }
                break;

            case R.id.interview_fold_3 :
                if(!interviewClicked3) {
                    interviewClicked3 = true;
                    interview3.setText(getResources().getString(R.string.INTERVIEW_3_DETAIL));
                    interviewFold3.setImageResource(R.drawable.fold_up_red);

                } else {
                    interviewClicked3 = false;
                    interview3.setText(getResources().getString(R.string.INTERVIEW_3_SUMMARY));
                    interviewFold3.setImageResource(R.drawable.fold_down_red);
                }
                break;

            case R.id.btnChallenge :
                BillingFlowParams flowParams = BillingFlowParams.newBuilder().setSkuDetails(skuDetails).build();
                billingClient.launchBillingFlow(this, flowParams);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bundle bundleClose = new Bundle();
        firebaseAnalytics.logEvent("challenge_close", bundleClose);
        finish();
    }
}
