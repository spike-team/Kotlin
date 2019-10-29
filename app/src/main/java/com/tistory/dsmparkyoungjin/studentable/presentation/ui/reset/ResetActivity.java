package com.tistory.dsmparkyoungjin.studentable.presentation.ui.reset;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.base.SetActivity;

import java.util.Objects;

public class ResetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);

        initView();
    }

    private void initView() {
        initActionBar();
        setOnClickSetSchool();
        setOnClickSetClass();
    }

    private void initActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_center_title);
        final TextView title = getSupportActionBar().getCustomView().findViewById(R.id.tv_title);
        title.setText("설정");
    }

    private void setOnClickSetSchool() {
        findViewById(R.id.tv_setAll).setOnClickListener(v -> {
            startActivity(new Intent(this, SetActivity.class).putExtra("TYPE", "SCHOOL"));
            finish();
        });
    }

    private void setOnClickSetClass() {
        findViewById(R.id.tv_setClass).setOnClickListener(v -> {
            startActivity(new Intent(this, SetActivity.class).putExtra("TYPE", "CLASS"));
            finish();
        });
    }
}
