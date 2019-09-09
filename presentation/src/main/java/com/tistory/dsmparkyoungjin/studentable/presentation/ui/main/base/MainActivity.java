package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.base;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal.MealFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(new MealFragment());
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_center_title);
        final TextView title = getSupportActionBar().getCustomView().findViewById(R.id.tv_title);
        title.setText("대덕소프트웨어마이스터고등학교 0학년 0반");
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_main, fragment).commit();
    }
}
