package net.awesomekorean.podo.challenge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.Constants;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.messaging.FirebaseMessaging;

import net.awesomekorean.podo.MainActivity;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UnixTimeStamp;
import net.awesomekorean.podo.UserInformation;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class Challenge extends AppCompatActivity implements View.OnClickListener, BillingProcessor.IBillingHandler {

    FirebaseAnalytics firebaseAnalytics;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    BillingProcessor bp;
    private String KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjttlMN7KIO22BMxNl1H2oN6FjRAUqQPvrlOKKybEwj0f2mXNreqpt5n/6/SV4+TAnADJSJO1j9MoN1fvVkYtr0zJtEe62hBcBouyqRKt/uWGhcy6ToMUlNjl9Wxf9UaSrJ3c0IePZvRtlGhd9y2OpK99uMfLjfqxY7+UIjnqBIO8qXSiy+E1jUrlR6AhZoBrwSfVSVPjOXya5K2uEngttMWaYwrnVhmBeEmjdIAjt0021plp4t7bYP5zSvwQp3dbomgnwE33njXWhn3ohla8m6wxZUPpZzvtCWKRo+SegyXx+wX2OVKcIkK27IrK9NEmrJzzamL2DLj/QhXKnk6aAQIDAQAB";

    FragmentPagerAdapter adapter;
    ArrayList<Integer> imageList;

    ImageView btnBack;
    TextView interview1;
    TextView interview2;
    TextView interview3;
    ImageView interviewFold1;
    ImageView interviewFold2;
    ImageView interviewFold3;
    Button btnChallenge;
    TextView textChallenge;

    boolean interviewClicked1 = false;
    boolean interviewClicked2 = false;
    boolean interviewClicked3 = false;

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
        btnBack.setOnClickListener(this);
        interviewFold1.setOnClickListener(this);
        interviewFold2.setOnClickListener(this);
        interviewFold3.setOnClickListener(this);
        btnChallenge.setOnClickListener(this);


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

        // analytics 로그 이벤트 얻기
        Bundle params = new Bundle();
        firebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());
        firebaseAnalytics.logEvent("challenge_page_open", params);
        FirebaseMessaging.getInstance().subscribeToTopic("challenge_page_open");

        bp = new BillingProcessor(this, KEY, this);
        bp.initialize();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(!bp.handleActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onDestroy() {
        if(bp != null) {
            bp.release();
        }
        super.onDestroy();
    }


    @Override
    public void onProductPurchased(String productId, TransactionDetails details) {
        // * 구매 완료시 호출

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

        //todo: 업데이트전에 지우기
        bp.consumePurchase(productId);

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onPurchaseHistoryRestored() {
        System.out.println("포인트 구매 복원!");
    }

    @Override
    public void onBillingError(int errorCode, Throwable error) {
        if(errorCode != Constants.BILLING_RESPONSE_RESULT_USER_CANCELED) {
            System.out.println("구매 오류가 발생했습니다." +  errorCode);
            Toast.makeText(getApplicationContext(), "FAILED Purchasing: "+errorCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onBillingInitialized() {
        System.out.println("포인트 구매 초기화!");
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnBack :
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
                bp.purchase(this, getString(R.string.SKU_CHALLENGE));
                break;
        }
    }
}
