package com.tistory.dsmparkyoungjin.studentable.presentation.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.iid.FirebaseInstanceId;
import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.base.BaseContract;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.base.MainActivity;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.base.SettingActivity;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity implements SplashContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(task -> {
                    if (!task.isSuccessful()) {
                        Log.w("err", "getInstanceId failed", task.getException());
                        return;
                    }

                    // Get new Instance ID token
                    Log.d("device", Objects.requireNonNull(task.getResult()).getToken());
                });

        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplication(), SettingActivity.class).putExtra("EditType", "first"));
            finish();
        }, 800);

        GoogleSignInOptions mGSIO =
                new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                        .requestIdToken(getResources().getString(R.string.backend_client_id))
                        .requestEmail()
                        .build();
        GoogleSignInClient mGSIC = GoogleSignIn.getClient(this, mGSIO);
        startActivity(mGSIC.getSignInIntent());
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
}
