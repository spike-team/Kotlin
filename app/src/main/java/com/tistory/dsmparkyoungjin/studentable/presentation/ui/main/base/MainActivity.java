package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.domain.local.MainPrefHelperImpl;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal.MealFragment;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.time.TimeFragment;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.notice.NoticeActivity;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.reset.ResetActivity;

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
        mPresenter.init(this);
    }

    public void replaceFragment(Fragment fragment) {
        if (fragment instanceof TimeFragment) mPresenter.setRecentViewTime();
        else mPresenter.setRecentViewMeal();

        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_main, fragment).commit();
    }

    @Override
    public void initView() {
        initActionBar();
        initFloatingActionBar();

        setRecentView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initActionBar();
    }

    @SuppressLint("SetTextI18n")
    private void initActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_center_title);
        final TextView title = getSupportActionBar().getCustomView().findViewById(R.id.tv_title);
        title.setText(mPresenter.getActionBarTitle());
    }

    private void initFloatingActionBar() {
        FloatingActionsMenu fam = findViewById(R.id.fab_menu);

        findViewById(R.id.fab_time).setOnClickListener(v -> {
            replaceFragment(mTimeFragment);
            fam.collapse();
        });

        findViewById(R.id.fab_meal).setOnClickListener(v -> {
            replaceFragment(mMealFragment);
            fam.collapse();
        });

        findViewById(R.id.fab_setting).setOnClickListener(v -> {
            startActivity(new Intent(this, ResetActivity.class));
            fam.collapse();
        });

        findViewById(R.id.fab_notification).setOnClickListener(v -> {
            startActivity(new Intent(this, NoticeActivity.class));
            fam.collapse();
        });
    }

    private void setRecentView() {
        switch (mPresenter.getRecentView()) {
            case MainPrefHelperImpl.TIME:
                replaceFragment(mTimeFragment);
                break;
            case MainPrefHelperImpl.MEAL:
                replaceFragment(mMealFragment);
                break;
        }
    }
}
