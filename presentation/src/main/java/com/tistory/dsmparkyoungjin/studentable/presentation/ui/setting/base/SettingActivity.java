package com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.base.MainActivity;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.search.SearchSchFragment;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.setting.set.SetClsFragment;

import java.util.Objects;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        replaceFragment(new SearchSchFragment());
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_center_title);
        final TextView title = getSupportActionBar().getCustomView().findViewById(R.id.tv_title);
        title.setText("설정");
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
    }

    public void selectSchool() {
        replaceFragment(new SetClsFragment());
    }

    public void setClass() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
