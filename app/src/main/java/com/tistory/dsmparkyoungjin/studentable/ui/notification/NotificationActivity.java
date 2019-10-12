package com.tistory.dsmparkyoungjin.studentable.ui.notification;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.adapter.NotificationAdapter;
import com.tistory.dsmparkyoungjin.studentable.entity.Notification;

import java.util.ArrayList;
import java.util.Objects;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

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
        ArrayList<Notification> dummy = new ArrayList<>();
        dummy.add(new Notification("9월 4일 수요일 1교시", "문학(장보현)이 국사(서현철)로 바뀌었습니다."));
        dummy.add(new Notification("9월 5일 목요일 1교시", "국사(서현철)가 문학(장보현)으로 바뀌었습니다."));

        RecyclerView rvNotification = findViewById(R.id.rv_notification);
        rvNotification.setAdapter(new NotificationAdapter(dummy));
    }

    private void initSwitch() {
        final int overlayWhite = 0;
        final int overlayBlack = 1140850688;

        Switch swcNotification = findViewById(R.id.swc_notification);
        FrameLayout flTransparency = findViewById(R.id.fl_transparency);
        TextView tvStateSwitch = findViewById(R.id.tv_stateSwitch);

        SharedPreferences pref = getSharedPreferences("STUDENTABLE", Context.MODE_PRIVATE);

        swcNotification.setChecked(pref.getBoolean("FCM_CHANGE", true));

        if(swcNotification.isChecked()) {
            flTransparency.setBackgroundColor(overlayWhite);
            pref.edit().putBoolean("FCM_CHANGE", true).apply();
            tvStateSwitch.setText("알림 기능 사용 중");
        } else {
            flTransparency.setBackgroundColor(overlayBlack);
            pref.edit().putBoolean("FCM_CHANGE", false).apply();
            tvStateSwitch.setText("알림 기능 사용 안함");
        }

        swcNotification.setOnCheckedChangeListener((buttonView, check) -> {
            if (check) {
                flTransparency.setBackgroundColor(overlayWhite);
                pref.edit().putBoolean("FCM_CHANGE", true).apply();
                tvStateSwitch.setText("알림 기능 사용 중");
            } else {
                flTransparency.setBackgroundColor(overlayBlack);
                pref.edit().putBoolean("FCM_CHANGE", false).apply();
                tvStateSwitch.setText("알림 기능 사용 안함");
            }
        });
    }
}
