package com.tistory.dsmparkyoungjin.studentable.ui.setting.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.ui.setting.search.SearchSchFragment;
import com.tistory.dsmparkyoungjin.studentable.ui.setting.select.SelectSchFragment;
import com.tistory.dsmparkyoungjin.studentable.ui.setting.set.SetClsFragment;

import java.util.Objects;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        switch (Objects.requireNonNull(getIntent().getStringExtra("TYPE"))) {
            case "SCHOOL":
                searchFragment();
                break;
            case "CLASS":
                setFragment();
                break;
        }
    }

    public void searchFragment() { replaceFragment(new SearchSchFragment()); }
    public void selectFragment(String school) {
        Fragment selectFragment = new SelectSchFragment();
        Bundle bundle = new Bundle();
        bundle.putString("SCHOOL", school);
        selectFragment.setArguments(bundle);
        replaceFragment(selectFragment);
    }
    public void setFragment() { replaceFragment(new SetClsFragment());}

    protected void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_setting, fragment).commit();
    }
}
