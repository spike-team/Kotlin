package com.tistory.dsmparkyoungjin.studentable.ui.main.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.domain.local.MainPrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.MainPrefHelperImpl;
import com.tistory.dsmparkyoungjin.studentable.ui.main.meal.MealFragment;
import com.tistory.dsmparkyoungjin.studentable.ui.main.time.TimeFragment;
import com.tistory.dsmparkyoungjin.studentable.ui.notice.NoticeActivity;
import com.tistory.dsmparkyoungjin.studentable.ui.reset.ResetActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;

    private MealFragment mMealFragment = new MealFragment();
    private TimeFragment mTimeFragment = new TimeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
    }

    public void replaceFragment(Fragment fragment) {
        MainPrefHelper helper = new MainPrefHelperImpl(getApplicationContext());
        if(fragment instanceof TimeFragment)
            helper.setRecentView(MainPrefHelperImpl.TIME);
        else
            helper.setRecentView(MainPrefHelperImpl.MEAL);

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_main, fragment).commit();
    }

    @Override
    public void initView() {
        initActionBar();
        initFloatingActionBar();

        setRecentView();
    }

    @SuppressLint("SetTextI18n")
    private void initActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_center_title);
        final TextView title = getSupportActionBar().getCustomView().findViewById(R.id.tv_title);

        SharedPreferences pref = getSharedPreferences("STUDENTABLE", Context.MODE_PRIVATE);
        title.setText(pref.getString("SCHOOL", "학교 이름") + " " + pref.getString("CLASS", "학년 반"));
    }

    private void initFloatingActionBar() {
        findViewById(R.id.fab_time).setOnClickListener(
                v -> replaceFragment(mTimeFragment)
        );

        findViewById(R.id.fab_meal).setOnClickListener(
                v -> replaceFragment(mMealFragment)
        );

        findViewById(R.id.fab_setting).setOnClickListener(
                v -> startActivity(new Intent(this, ResetActivity.class))
        );

        findViewById(R.id.fab_notification).setOnClickListener(
                v -> startActivity(new Intent(this, NoticeActivity.class))
        );
    }

    private void setRecentView() {
        MainPrefHelper helper = new MainPrefHelperImpl(getApplicationContext());
        switch (helper.getRecentView()) {
            case MainPrefHelperImpl.TIME:
                replaceFragment(mTimeFragment);
                break;
            case MainPrefHelperImpl.MEAL:
                replaceFragment(mMealFragment);
                break;
        }
    }
}
