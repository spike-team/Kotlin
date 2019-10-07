package com.tistory.dsmparkyoungjin.studentable.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.ui.main.base.MainActivity;
import com.tistory.dsmparkyoungjin.studentable.ui.setting.base.SettingActivity;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    private final int RC_SUCCESS_GOOGLE_AUTH = 1001;
    private final String STUDENTABLE = "STUDENTABLE";
    private final String DEVICE_CODE = "DEVICE_CODE";
    private final String GOOGLE_AUTH = "GOOGLE_AUTH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(isSet()) {
            new Handler().postDelayed(() -> {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }, 800);
        } else {
            GoogleSignInOptions mGSIO =
                    new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                            .requestIdToken(getResources().getString(R.string.web_client_id))
                            .requestEmail()
                            .build();
            GoogleSignInClient mGSIC = GoogleSignIn.getClient(this, mGSIO);
            startActivityForResult(mGSIC.getSignInIntent(), RC_SUCCESS_GOOGLE_AUTH);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SUCCESS_GOOGLE_AUTH) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                assert account != null;
                firebaseAuthWithGoogle(account);
                fcmDeviceCode();
            } catch (ApiException e) {
                Log.w("SplashActivity", "Google sign in failed", e);
            }
        }

        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplication(), SettingActivity.class).putExtra("EDIT", "SCHOOL"));
            finish();
        }, 800);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount mGoogleAccount) {
        SharedPreferences pref = getSharedPreferences(STUDENTABLE, Context.MODE_PRIVATE);
        pref.edit().putString(GOOGLE_AUTH, mGoogleAccount.getId()).apply();
    }

    private void fcmDeviceCode() {
        SharedPreferences pref = getSharedPreferences(STUDENTABLE, Context.MODE_PRIVATE);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w("err", "getInstanceId failed", task.getException());
                        return;
                    }
                    pref.edit().putString(DEVICE_CODE, Objects.requireNonNull(task.getResult()).getToken()).apply();
                });
    }

    private Boolean isSet() {
        SharedPreferences pref = getSharedPreferences(STUDENTABLE, Context.MODE_PRIVATE);
        return pref.getString(DEVICE_CODE, "").isEmpty()
                && pref.getString(GOOGLE_AUTH, "").isEmpty();
    }
}
