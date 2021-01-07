package net.awesomekorean.podo;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.android.billingclient.api.AccountIdentifiers;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class PurchaseInfo {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public String orderId;
    public String userEmail;
    public String tag;

    public String purchaseToken;
    public int purchaseState;
    public Long purchaseTime;
    public AccountIdentifiers accountIdentifiers;
    public String signature;
    public boolean acknowledged;
    public String sku;
    public String skuPrice;

    public int responseCode;
    public String responseMessage;


    public PurchaseInfo(Context context, BillingResult billingResult, Purchase purchase, String skuPrice) {
        String CHALLENGER = "challenger";
        String POINT = "point";

        this.orderId = purchase.getOrderId();
        this.userEmail = SharedPreferencesInfo.getUserEmail(context);
        this.purchaseToken = purchase.getPurchaseToken();
        this.purchaseState = purchase.getPurchaseState();
        this.purchaseTime = purchase.getPurchaseTime();
        this.accountIdentifiers = purchase.getAccountIdentifiers();
        this.acknowledged = purchase.isAcknowledged();
        this.signature = purchase.getSignature();
        this.sku = purchase.getSku();
        this.skuPrice = skuPrice;
        this.responseCode = billingResult.getResponseCode();
        this.responseMessage = billingResult.getDebugMessage();
        if(sku.contains(CHALLENGER)) {
            this.tag = CHALLENGER;
        } else if(sku.contains(POINT)) {
            this.tag = POINT;
        }
    }


    public boolean checkPurchase() {
        String GPA = "GPA";
        String subOrderId = orderId.substring(0, 3);
        if (subOrderId.equals(GPA)) {
            System.out.println("True purchasing");
            return true;
        } else {
            System.out.println("Fake purchasing");
            return false;
        }
    }


    public void uploadInfo() {
        db.collection("android/podo/purchase").add(this).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                System.out.println("구매기록을 저장했습니다.");
            }
        });
    }
}
