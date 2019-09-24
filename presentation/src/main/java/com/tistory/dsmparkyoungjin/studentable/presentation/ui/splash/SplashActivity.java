package com.tistory.dsmparkyoungjin.studentable.presentation.ui.splash;

import android.content.Intent;
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
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.base.BaseContract;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.base.MainActivity;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.base.SettingActivity;

import java.util.Objects;

import javax.inject.Inject;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    @Inject
    SplashContract.Presenter mPresenter;

    private int RC_SUCCESS_GOOGLE_AUTH = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        GoogleSignInOptions mGSIO =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getResources().getString(R.string.web_client_id))
                        .requestEmail()
                        .build();
        GoogleSignInClient mGSIC = GoogleSignIn.getClient(this, mGSIO);
        startActivityForResult(mGSIC.getSignInIntent(), RC_SUCCESS_GOOGLE_AUTH);
    }

    @Override
    public void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void startSettingActivity() {
        startActivity(
                new Intent(this, SettingActivity.class)
                        .putExtra("editType", "first")
        );
    }

    @Override
    public void setPresenter(BaseContract.Presenter mPresenter) {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RC_SUCCESS_GOOGLE_AUTH) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                assert account != null;
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                Log.w("SplashActivity", "Google sign in failed", e);
            }
        }

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w("err", "getInstanceId failed", task.getException());
                        return;
                    }

                    Log.d("device", Objects.requireNonNull(task.getResult()).getToken());
                });

        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplication(), SettingActivity.class).putExtra("EditType", "first"));
            finish();
        }, 800);
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount mGoogleAccount) {
        //TODO use googleSignInAccount.getId
    }
}
