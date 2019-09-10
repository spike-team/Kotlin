package com.tistory.dsmparkyoungjin.studentable.presentation.ui.reset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.base.SettingActivity;

public class ResetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        findViewById(R.id.tv_setAll).setOnClickListener(v -> {
            startActivity(new Intent(this, SettingActivity.class).putExtra("EditType", "all"));
            finish();
        });

        findViewById(R.id.tv_setClass).setOnClickListener(v -> {
            startActivity(new Intent(this, SettingActivity.class).putExtra("EditType", "class"));
            finish();
        });
    }
}