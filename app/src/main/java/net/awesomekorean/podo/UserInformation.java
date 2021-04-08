package net.awesomekorean.podo;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class UserInformation {

    private Long dateSignUp;
    private List<Boolean> attendance = new ArrayList<>(7); // [0]~[6], 일~토
    private int points;
    private int pointsPurchased;
    private List<String> lessonComplete = new ArrayList<>();
    private List<String> readingComplete = new ArrayList<>();
    private List<String> specialLessonUnlock = new ArrayList<>();
    private List<String> readingUnlock = new ArrayList<>();
    private List<String> lessonUnlock = new ArrayList<>();
    private Long lastVisit;
    private int isChallenger;   // 0:챌린저아님, 1:챌린지중, 2:챌린지만료
    private int isChallengeRewarded;    //0:아직, 1:성공, 2:실패
    private Long dateChallengeStart;
    private Long dateChallengeExpire;

    public UserInformation() {
        for(int i=0; i<7; i++) {
            this.attendance.add(false);
        }
        this.points = 10;
        this.pointsPurchased = 0;
        this.isChallenger = 0;
        this.isChallengeRewarded = 0;
    }

    public List<Boolean> getAttendance() {
        return attendance;
    }

    public void setAttendance(List<Boolean> attendance) {
        this.attendance = attendance;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<String> getLessonComplete() {
        return lessonComplete;
    }

    // 신규 완료정보 변경을 위해 만듦 (L_00%100 --> L_00)
    public void setLessonComplete(List<String> lessonComplete) {
        this.lessonComplete = lessonComplete;
    }
    public void setReadingComplete(List<String> readingComplete) {
        this.readingComplete = readingComplete;
    }


    // 완료리스트 업데이트하고 앱이랑 DB도 바로 업데이트 함
    public void updateCompleteList(Context context, String unitId, boolean isReading) {
        if(isReading) {
            if(!readingComplete.contains(unitId)) {
                readingComplete.add(unitId);
                SharedPreferencesInfo.setUserInfo(context, this);
                updateDb(context);
            } else {
                System.out.println("이미 완료한 읽기입니다.");
            }

        } else {
            if(!lessonComplete.contains(unitId)) {
                lessonComplete.add(unitId);
                SharedPreferencesInfo.setUserInfo(context, this);
                updateDb(context);

                // L_00 완료시 이벤트 등록
                if(unitId != null) {
                    if (unitId.equals("L_00")) {
                        System.out.println("L_00를 완료했습니다. 이벤트를 등록합니다.");
                        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
                        Bundle bundle = new Bundle();
                        firebaseAnalytics.logEvent("L_00_complete", bundle);

                        SharedPreferencesInfo.setChallengerDiscountAvailable(context, true);
                    }
                }
            } else {
                System.out.println("이미 완료한 레슨입니다.");
            }
        }
    }


    // 포인트 합산하기
    public void addRewardPoints(Context context, int rewardPoints){
        int oldPoints = getPoints();
        int newPoints = oldPoints + rewardPoints;
        setPoints(newPoints);
        SharedPreferencesInfo.setUserInfo(context, this);
        this.updateDb(context);
    }


    // 포인트 합산하기 (DB 업데이트 안함)
    public void addRewardPointsWithoutDB(int rewardPoints){
        int oldPoints = getPoints();
        int newPoints = oldPoints + rewardPoints;
        setPoints(newPoints);
    }


    // DB 에 유저 정보 업데이드 하기
    public void updateDb(final Context context) {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String userEmail = SharedPreferencesInfo.getUserEmail(context);

        db.collection(context.getString(R.string.DB_USERS)).document(userEmail)
                .set(this)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        System.out.println("DB에 유저 정보를 업데이트 했습니다.");
                    }
                });
    }


    public List<String> getReadingComplete() {
        return readingComplete;
    }

    public void addReadingComplete(String readingId) {
        this.readingComplete.add(readingId);
    }

    public int getIsChallenger() {return isChallenger;}

    public void setIsChallenger(int b) {
        this.isChallenger = b;
    }

    public int getIsChallengeRewarded() {
        return isChallengeRewarded;
    }

    public void setIsChallengeRewarded(int isChallengeRewarded) {
        this.isChallengeRewarded = isChallengeRewarded;
    }

    public Long getDateChallengeStart() {
        return dateChallengeStart;
    }

    public void setDateChallengeStart(Long dateChallengeStart) {
        this.dateChallengeStart = dateChallengeStart;
    }

    public Long getDateChallengeExpire() {
        return dateChallengeExpire;
    }

    public void setDateChallengeExpire(Long dateChallengeExpire) {
        this.dateChallengeExpire = dateChallengeExpire;
    }

    public List<String> getSpecialLessonUnlock() {
        return specialLessonUnlock;
    }

    public void addSpecialLessonUnlock(String lessonId) {
        this.specialLessonUnlock.add(lessonId);
    }

    public List<String> getReadingUnlock() {
        return readingUnlock;
    }

    public void addReadingUnlock(String readingId) {
        this.readingUnlock.add(readingId);
    }

    public List<String> getLessonUnlock() {
        return lessonUnlock;
    }

    public void addLessonUnlock(String lessonId) {
        this.lessonUnlock.add(lessonId);
    }

    public void resetDays(int today) {
        for(int i=0; i<7; i++) {
            this.attendance.set(i, false);
        }
        this.attendance.set(today, true);
    }

    public void setDay(int today) {
        this.attendance.set(today, true);
    }

    public void setLastVisit() { this.lastVisit = UnixTimeStamp.getTimeNow();}

    public Long getLastVisit() {
        return lastVisit;
    }

    public int getPointsPurchased() {
        return this.pointsPurchased;
    }

    public void setPointsPurchased(int pointsPurchased) {
        this.pointsPurchased += pointsPurchased;
    }

    public Long getDateSignUp() {
        return dateSignUp;
    }

    public void setDateSignUp(Long dateSignUp) {
        this.dateSignUp = dateSignUp;
    }
}
