package net.awesomekorean.podo;

import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import net.awesomekorean.podo.challenge.Challenge;
import net.awesomekorean.podo.collection.MainCollection;
import net.awesomekorean.podo.lesson.MainLesson;
import net.awesomekorean.podo.login.SignIn;
import net.awesomekorean.podo.profile.Profile;
import net.awesomekorean.podo.purchase.TopUp;
import net.awesomekorean.podo.qna.MainQnA;
import net.awesomekorean.podo.reading.MainReading;
import net.awesomekorean.podo.writing.MainWriting;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseCrashlytics crashlytics = FirebaseCrashlytics.getInstance();

    private final String SEGMENT_CHALLENGE = "challenge";
    private final String DISCOUNT = "discount";

    FragmentManager fm;
    FragmentTransaction tran;
    Fragment mainLesson;
    Fragment mainReading;
    Fragment mainWriting;
    Fragment mainCollection;
    Fragment mainQnA;

    TextView tvTitle;

    ImageView btnProfile;
    TextView userPoint;
    LinearLayout layoutPoint;

    ConstraintLayout layoutPointDetail;
    ConstraintLayout layoutGetPoint;
    ConstraintLayout layoutPointInfo;
    ImageView btnPointInfo;
    ImageView btnClosePointDetail;
    Button btnWatchAds;
    Button btnPurchasePoints;
    Button btnClosePointInfo;

    LinearLayout layoutLesson;
    LinearLayout layoutReading;
    LinearLayout layoutWriting;
    LinearLayout layoutCollection;
    LinearLayout layoutQnA;


    public static ImageView btnLesson;
    public static ImageView btnReading;
    public static ImageView btnWriting;
    public static ImageView btnCollection;
    public static ImageView btnQnA;
    public static TextView textLesson;
    public static TextView textReading;
    public static TextView textWriting;
    public static TextView textCollection;
    public static TextView textQnA;

    Intent intent;

    public static String userEmail;
    public static String userName;
    public static Uri userImage;

    UserInformation userInformation;

    Animation animation;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        SettingStatusBar.setStatusBar(this);

        tvTitle = findViewById(R.id.tvTitle);
        btnProfile = findViewById(R.id.btnProfile);
        userPoint = findViewById(R.id.userPoint);
        layoutPoint = findViewById(R.id.layoutPoint);
        layoutPointDetail = findViewById(R.id.layoutPointDetail);
        layoutGetPoint = findViewById(R.id.layoutGetPoint);
        layoutPointInfo = findViewById(R.id.layoutPointInfo);
        btnPointInfo = findViewById(R.id.btnPointInfo);
        btnClosePointDetail = findViewById(R.id.btnClosePointDetail);
        btnWatchAds = findViewById(R.id.btnWatchAds);
        btnPurchasePoints = findViewById(R.id.btnPurchasePoints);
        btnClosePointInfo = findViewById(R.id.btnClosePointInfo);
        layoutLesson = findViewById(R.id.layoutLesson);
        layoutReading = findViewById(R.id.layoutReading);
        layoutWriting = findViewById(R.id.layoutWriting);
        layoutCollection = findViewById(R.id.layoutCollection);
        layoutQnA = findViewById(R.id.layoutQnA);
        btnLesson = findViewById(R.id.btnLesson);
        btnReading = findViewById(R.id.btnReading);
        btnWriting = findViewById(R.id.btnWriting);
        btnCollection = findViewById(R.id.btnCollection);
        btnQnA = findViewById(R.id.btnQnA);
        textLesson = findViewById(R.id.textLesson);
        textReading = findViewById(R.id.textReading);
        textWriting = findViewById(R.id.textWriting);
        textCollection = findViewById(R.id.textCollection);
        textQnA = findViewById(R.id.textQnA);
        btnProfile.setOnClickListener(this);
        layoutPoint.setOnClickListener(this);
        btnPointInfo.setOnClickListener(this);
        btnClosePointDetail.setOnClickListener(this);
        btnWatchAds.setOnClickListener(this);
        btnPurchasePoints.setOnClickListener(this);
        btnClosePointInfo.setOnClickListener(this);
        layoutLesson.setOnClickListener(this);
        layoutReading.setOnClickListener(this);
        layoutWriting.setOnClickListener(this);
        layoutCollection.setOnClickListener(this);
        layoutQnA.setOnClickListener(this);


        mainLesson = new MainLesson();
        mainReading = new MainReading();
        mainWriting = new MainWriting();
        mainCollection = new MainCollection();
        mainQnA = new MainQnA();
        setFrag(mainLesson);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_200);

        // 유저정보 가져오기 (Email, Name, Image)
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            userEmail = user.getEmail();
            if (user.getDisplayName() != null) {
                userName = user.getDisplayName();
            } else {
                userName = userEmail.substring(0, userEmail.lastIndexOf("@"));
            }
            userImage = user.getPhotoUrl();
        }

        SharedPreferencesInfo.setUserEmail(getApplicationContext(), userEmail);
        SharedPreferencesInfo.setUserName(getApplicationContext(), userName);

        crashlytics.log("setting CustomKey");
        crashlytics.setCustomKey("userEmail", userEmail);
        crashlytics.setCustomKey("userName", userName);

        getAttendanceInfo();

        checkPlayService();

        Intent intent = new Intent(this, FirebaseCloudMessage.class);
        startService(intent);


        // 딥링크 리스너
        FirebaseDynamicLinks.getInstance()
                .getDynamicLink(getIntent())
                .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {
                    @Override
                    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        System.out.println("딥링크 수신 성공");

                        Uri deepLink = null;
                        if (pendingDynamicLinkData != null) {
                            deepLink = pendingDynamicLinkData.getLink();
                        }
                        System.out.println("딥링크 Uri : " + deepLink);

                        if(deepLink != null) {
                            String segment = deepLink.getLastPathSegment();
                            String discount = deepLink.getQueryParameter(DISCOUNT);

                            Intent deepLinkIntent;
                            if(segment.equals(SEGMENT_CHALLENGE)) {
                                deepLinkIntent = new Intent(getApplicationContext(), Challenge.class);
                            } else {
                                deepLinkIntent = new Intent(getApplicationContext(), TopUp.class);
                            }

                            if(discount != null) {
                                int percent = Integer.parseInt(discount);

                                deepLinkIntent.putExtra(DISCOUNT, percent);
                                startActivity(deepLinkIntent);

                                System.out.println("세그먼트 : " + segment);
                                System.out.println("할인 : " + discount);
                                System.out.println("퍼센트 : " + percent);
                            }
                        }
                    }
                }).addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("딥링크 수신 실패 : " + e);
                    }
                });
    }


    // 앱에서 유저 데이터 가져오기
    public void getAttendanceInfo() {
        System.out.println("앱에서 유저 데이터를 가져옵니다.");
        userInformation = SharedPreferencesInfo.getUserInfo(getApplicationContext());

        final Calendar cal = Calendar.getInstance();
        final int today = cal.get(Calendar.DAY_OF_WEEK) - 1; // 0:일요일 ~ 6:토요일

        // 오늘 출석체크 안했으면 출석부 업데이트 (버그: 요일이 같으면 일주일만에 접속해도 초기화 안됨)
        if (userInformation != null && !userInformation.getAttendance().get(today)) {

            // 챌린저 날짜 체크
            if(userInformation.getIsChallenger() == 1) {
                checkChallenge();
            }

            System.out.println("출석체크를 시작합니다.");
            int yesterday;
            if (today == 0) {
                yesterday = 6;
            } else {
                yesterday = today - 1;
            }

            // 어제 출석 했는지 확인하고 안했으면 출석부 초기화 (오늘만 출석표시)
            if (!userInformation.getAttendance().get(yesterday)) {
                System.out.println("어제 출석하지 않았습니다");
                userInformation.resetDays(today);

                // 어제도 출석했으면 오늘 출석 표시
            } else {
                System.out.println("어제도 출석했습니다");
                userInformation.setDay(today);
            }

            userInformation.setLastVisit();

            SharedPreferencesInfo.setUserInfo(getApplicationContext(), userInformation);
            System.out.println("앱에 출석부를 업데이트 했습니다");

            // DB 에 출석부 업데이트하기
            DocumentReference reference = db.collection(getString(R.string.DB_USERS)).document(userEmail);
            reference.update("attendance", userInformation.getAttendance()).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    System.out.println("DB에 출석부를 업데이트 했습니다");
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    System.out.println("출석부 업데이트를 실패했습니다:" + e);
                }
            });

            reference.update("lastVisit", UnixTimeStamp.getTimeNow()).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    System.out.println("DB에 마지막 방문시간을 업데이트 했습니다");
                }
            });


        } else {
            System.out.println("오늘의 출석체크가 이미 끝났습니다.");
        }
    }


    // 챌린지 완료여부 체크
    private void checkChallenge() {
        //보상 받았는지 확인
        if(userInformation.getIsChallengeRewarded() == 0) {
            Long timeNow = UnixTimeStamp.getTimeNow();
            Long timeExpire = userInformation.getDateChallengeExpire();

            // 챌린지시간 끝났는지 확인
            if(timeNow >= timeExpire) {
                userInformation.setIsChallenger(2);
                System.out.println("챌린지 종료!");
            }
        }
    }


    public void checkPlayService() {
        GoogleApiAvailability googleAPI = GoogleApiAvailability.getInstance();
        int result = googleAPI.isGooglePlayServicesAvailable(this);

        if(result != ConnectionResult.SUCCESS) {
            googleAPI.makeGooglePlayServicesAvailable(this);
        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnProfile:
                intent = new Intent(this, Profile.class);
                startActivity(intent);
                break;

            case R.id.layoutPoint :
                layoutPointDetail.setVisibility(View.VISIBLE);
                layoutGetPoint.setVisibility(View.VISIBLE);
                layoutPointInfo.setVisibility(View.GONE);
                break;

            case R.id.btnWatchAds :
                AdsManager.getInstance().playRewardAds(this);
                break;

            case R.id.btnPurchasePoints :
                intent = new Intent(getApplicationContext(), TopUp.class);
                startActivity(intent);
                break;

            case R.id.btnPointInfo :
                layoutGetPoint.setVisibility(View.GONE);
                layoutPointInfo.setVisibility(View.VISIBLE);
                break;

            case R.id.btnClosePointDetail :
                layoutPointDetail.setVisibility(View.GONE);
                break;

            case R.id.btnClosePointInfo :
                layoutGetPoint.setVisibility(View.VISIBLE);
                layoutPointInfo.setVisibility(View.GONE);
                break;


            case R.id.layoutLesson:
                setFrag(mainLesson);
                setMainBtns(btnLesson, textLesson, R.drawable.lesson_active, R.string.LESSON);
                break;

            case R.id.layoutReading:
                setFrag(mainReading);
                setMainBtns(btnReading, textReading, R.drawable.reading_active, R.string.READING);
                break;

            case R.id.layoutWriting:
                setFrag(mainWriting);
                setMainBtns(btnWriting, textWriting, R.drawable.writing_active, R.string.WRITING);
                break;

            case R.id.layoutCollection:
                setFrag(mainCollection);
                setMainBtns(btnCollection, textCollection, R.drawable.collection_active, R.string.COLLECTION);
                break;

            case R.id.layoutQnA:
                setFrag(mainQnA);
                setMainBtns(btnQnA, textQnA, R.drawable.qna_active, R.string.QNA);
                break;
        }
    }


    public void setFrag(Fragment frag) {
        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();
        tran.replace(R.id.frameLayout, frag);
        tran.commit();
    }


    public void setMainBtns(ImageView btn, TextView text, int active, int title) {
        btnLesson.setImageResource(R.drawable.lesson);
        btnReading.setImageResource(R.drawable.reading);
        btnWriting.setImageResource(R.drawable.writing);
        btnCollection.setImageResource(R.drawable.collection);
        btnQnA.setImageResource(R.drawable.qna);

        textLesson.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.GREY_DARK));
        textReading.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.GREY_DARK));
        textWriting.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.GREY_DARK));
        textCollection.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.GREY_DARK));
        textQnA.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.GREY_DARK));

        btn.setImageResource(active);
        text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.PURPLE));
        btn.startAnimation(animation);
        tvTitle.setText(getString(title));
    }


    public void openConfirmQuit() {
        Intent intent = new Intent(this, ConfirmQuit.class);
        intent.putExtra(getResources().getString(R.string.IS_MAIN), true);
        startActivity(intent);
    }


    @Override
    protected void onResume() {
        super.onResume();
        checkPlayService();
        System.out.println("메인 보임!");
        if(userInformation != null) {
            userInformation = SharedPreferencesInfo.getUserInfo(getApplicationContext());
            userPoint.setText(String.valueOf(userInformation.getPoints()));

            // 애널리틱스 로그이벤트 (챌린저 진행 중인 유저가 아니면서 포인트가 5 이하일 때)
            if(userInformation.getPoints() < 5 && userInformation.getIsChallenger() != 1) {
                Bundle params = new Bundle();
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(getApplicationContext());
                firebaseAnalytics.logEvent("point_not_enough", params);
            }
        }

        if(!IsOnline.isOnline(getApplicationContext())) {
            Toast.makeText(getApplicationContext(), "Internet connection required.", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, SignIn.class);
            startActivity(intent);
            finish();
        }
    }


    @Override
    public void onBackPressed() {
        openConfirmQuit();
    }


    @Override
    protected void onPause() {
        super.onPause();
        crashlytics.log("메인액티비티 Pause!!");
        System.out.println("메인액티비티 Pause!!");
    }


    @Override
    protected void onStop() {
        super.onStop();
        crashlytics.log("메인액티비티 Stop!!");
        System.out.println("메인액티비티 Stop!!");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        crashlytics.log("메인액티비티 Destroy!!");
        System.out.println("메인액티비티 Destroy!!");
    }
}



