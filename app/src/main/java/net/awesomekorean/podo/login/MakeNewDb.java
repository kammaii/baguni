package net.awesomekorean.podo.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import net.awesomekorean.podo.MainActivity;
import net.awesomekorean.podo.R;
import net.awesomekorean.podo.SharedPreferencesInfo;
import net.awesomekorean.podo.UserInformation;
import net.awesomekorean.podo.message.MessageItems;

import static com.facebook.FacebookSdk.getApplicationContext;

public class MakeNewDb {

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    public void makeNewDb(final Activity activity, final Context context, final String userEmail, final String method) {
        final UserInformation userInformation = new UserInformation();

        CollectionReference userRef = db.collection(activity.getString(R.string.DB_USERS));
        userRef.document(userEmail).set(userInformation).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                System.out.println("유저정보 DB를 만들었습니다");
                UserInformation userInformation = new UserInformation();
                SharedPreferencesInfo.setUserInfo(getApplicationContext(), userInformation);
                System.out.println("앱에 유저 데이터를 저장했습니다.");

                Toast.makeText(context, activity.getString(R.string.WELCOME), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                MainActivity.userEmail = userEmail;
                activity.finish();
                activity.startActivity(intent);


                // SignUp 로그 이벤트 얻기
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.METHOD, method);
                firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SIGN_UP, bundle);

                /*
                final MessageItems messageItems = new MessageItems();
                messageItems.setMessage(activity.getString(R.string.WELCOME_MSG));
                CollectionReference messageRef = db.collection(activity.getString(R.string.DB_USERS)).document(userEmail).collection(activity.getString(R.string.DB_MESSAGES));
                messageRef.add(messageItems).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        System.out.println("메시지 DB를 만들었습니다");
                        Toast.makeText(context, activity.getString(R.string.WELCOME), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        MainActivity.userEmail = userEmail;
                        activity.finish();
                        activity.startActivity(intent);


                        // SignUp 로그 이벤트 얻기
                        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
                        Bundle bundle = new Bundle();
                        bundle.putString(FirebaseAnalytics.Param.METHOD, method);
                        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SIGN_UP, bundle);
                    }
                });

                 */
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), "Failed: User DB is not created"+e, Toast.LENGTH_LONG).show();
            }
        });
    }
}
