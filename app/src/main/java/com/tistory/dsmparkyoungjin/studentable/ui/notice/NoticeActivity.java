package com.tistory.dsmparkyoungjin.studentable.ui.notice;

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

public class NoticeActivity extends AppCompatActivity implements NoticeContract.View {

    private NoticeContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);

        mPresenter = new NoticePresenter(this);
        mPresenter.init(this);
    }

    @Override
    public void initView() {
        initActionBar();
        initRecyclerView();
        initSwitch();
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
        Switch swcNotice = findViewById(R.id.swc_notice);
        swcNotice.setChecked(mPresenter.isEnable());

        check(swcNotice.isChecked());
        swcNotice.setOnCheckedChangeListener(
                (buttonView, isCheck) -> check(isCheck)
        );
    }

    private void check(Boolean check) {
        TextView tvStateSwitch = findViewById(R.id.tv_stateSwitch);
        FrameLayout flTransparency = findViewById(R.id.fl_transparency);

        if (check) {
            mPresenter.setEnable();
            flTransparency.setVisibility(View.GONE);
            tvStateSwitch.setText("알림 기능 사용 중");
        } else {
            mPresenter.setDisable();
            flTransparency.setVisibility(View.VISIBLE);
            tvStateSwitch.setText("알림 기능 사용 안함");
        }
    }
}