package com.tistory.dsmparkyoungjin.studentable.ui.notice;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.adapter.NoticeAdapter;
import com.tistory.dsmparkyoungjin.studentable.data.NoticeData;

import java.util.ArrayList;
import java.util.Objects;

public class NoticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        initView();
    }

    private void initView() {
        initActionBar();
        initSwitch();
        initRecyclerView();
    }

    private void initActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_center_title);
        final TextView title = getSupportActionBar().getCustomView().findViewById(R.id.tv_title);
        title.setText("알림");
    }

    private void initRecyclerView() {
        ArrayList<NoticeData> dummy = new ArrayList<>();
        dummy.add(new NoticeData("9월 4일 수요일 1교시", "문학(장보현)이 국사(서현철)로 바뀌었습니다."));
        dummy.add(new NoticeData("9월 5일 목요일 1교시", "국사(서현철)가 문학(장보현)으로 바뀌었습니다."));

        RecyclerView rvNotice = findViewById(R.id.rv_notification);
        NoticeAdapter adapter = new NoticeAdapter(dummy);
        rvNotice.setAdapter(adapter);
    }

    private void initSwitch() {

        Switch swcNotification = findViewById(R.id.swc_notification);
        TextView tvStateSwitch = findViewById(R.id.tv_stateSwitch);
        FrameLayout flTransparency = findViewById(R.id.fl_transparency);

        SharedPreferences pref = getSharedPreferences("STUDENTABLE", Context.MODE_PRIVATE);

        swcNotification.setChecked(pref.getBoolean("FCM_CHANGE", true));

        if(swcNotification.isChecked()) {
            flTransparency.setVisibility(View.GONE);
            pref.edit().putBoolean("FCM_CHANGE", true).apply();
            tvStateSwitch.setText("알림 기능 사용 중");
        } else {
            flTransparency.setVisibility(View.VISIBLE);
            pref.edit().putBoolean("FCM_CHANGE", false).apply();
            tvStateSwitch.setText("알림 기능 사용 안함");
        }

        swcNotification.setOnCheckedChangeListener((buttonView, check) -> {
            if (check) {
                flTransparency.setVisibility(View.GONE);
                pref.edit().putBoolean("FCM_CHANGE", true).apply();
                tvStateSwitch.setText("알림 기능 사용 중");
            } else {
                flTransparency.setVisibility(View.VISIBLE);
                pref.edit().putBoolean("FCM_CHANGE", false).apply();
                tvStateSwitch.setText("알림 기능 사용 안함");
            }
        });
    }
}
