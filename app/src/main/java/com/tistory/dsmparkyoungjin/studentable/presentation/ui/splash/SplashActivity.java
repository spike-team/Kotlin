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
import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.base.MainActivity;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.base.SetActivity;

import java.util.Objects;

import io.realm.Realm;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    private SplashContract.Presenter mPresenter;
    private String mGoogleAuth;

    private static final int RC_SUCCESS_GOOGLE_AUTH = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPresenter = new SplashPresenter(this);
        mPresenter.init(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SUCCESS_GOOGLE_AUTH) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                mGoogleAuth = Objects.requireNonNull(task.getResult(ApiException.class)).getEmail();
                mPresenter.setGoogleAuth();
            } catch (ApiException e) {
                Log.w("SplashActivity", "Google sign in failed", e);
            }
        }

        startSetActivity();
    }

    @Override
    public void initView() {
        initRealm();
        splash();
    }

    @Override
    public String getGoogleAuth() {
        return mGoogleAuth;
    }

    private void splash() {
        new Handler().postDelayed(() -> {
            if (mPresenter.isSet()) startMainActivity();
            else googleAuthSignIn();
        }, 800);
    }

    private void googleAuthSignIn() {
        GoogleSignInOptions googleSignInOptions =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getResources().getString(R.string.web_client_id))
                        .requestEmail()
                        .build();
        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        startActivityForResult(googleSignInClient.getSignInIntent(), RC_SUCCESS_GOOGLE_AUTH);
    }

    private void startSetActivity() {
        startActivity(new Intent(getApplication(), SetActivity.class).putExtra("TYPE", "FIRST"));
        finish();
    }

    private void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void initRealm() {
        Realm.init(this);
    }
}
