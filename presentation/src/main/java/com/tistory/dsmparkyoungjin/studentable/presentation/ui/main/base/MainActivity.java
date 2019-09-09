package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.base;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal.MealFragment;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.time.TimeFragment;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.reset.ResetActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private MealFragment mMealFragment = new MealFragment();
    private TimeFragment mTimeFragment = new TimeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(mMealFragment);
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_center_title);
        final TextView title = getSupportActionBar().getCustomView().findViewById(R.id.tv_title);
        title.setText("대덕소프트웨어마이스터고등학교 0학년 0반");

        findViewById(R.id.fab_meal).setOnClickListener(
                v -> replaceFragment(mMealFragment)
        );

        findViewById(R.id.fab_setting).setOnClickListener(v ->
            startActivity(new Intent(this, ResetActivity.class))
        );
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_main, fragment).commit();
    }
}
