package com.tistory.dsmparkyoungjin.studentable.ui.setting.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
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

        initView();
        SharedPreferences temp = getSharedPreferences("STUDENTABLE", Context.MODE_PRIVATE);
        Log.d("TEST", "GOOGLEAUTH: " + temp.getString("GOOGLE_AUTH", ""));
        Log.d("TEST", "DEVICECODE: " + temp.getString("DEVICE_CODE", ""));
    }

    private void initView() {
        initActionBar();
        initFragment();
    }

    private void initFragment() {
        switch (Objects.requireNonNull(getIntent().getStringExtra("TYPE"))) {
            case "SCHOOL":
                searchFragment();
                break;
            case "CLASS":
                setFragment();
                break;
        }
    }

    private void initActionBar() {
        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_center_title);
        final TextView title = getSupportActionBar().getCustomView().findViewById(R.id.tv_title);
        title.setText("설정");
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
