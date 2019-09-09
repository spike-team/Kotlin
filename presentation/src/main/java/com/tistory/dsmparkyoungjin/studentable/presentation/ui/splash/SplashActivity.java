package com.tistory.dsmparkyoungjin.studentable.presentation.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.base.SettingActivity;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

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
            startActivity(new Intent(getApplication(), SettingActivity.class));
            finish();
        }, 800);
    }
}
