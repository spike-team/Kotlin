package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.base;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.base.MainActivity;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.search.SearchSchFragment;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.select.SelectSchFragment;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.set.SetClsFragment;

import java.util.Objects;

public class SetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);

        initView();
    }

    private void initView() {
        initActionBar();
        initFragment();
    }

    private void initFragment() {
        switch (Objects.requireNonNull(getIntent().getStringExtra("TYPE"))) {
            case "SCHOOL":
            case "FIRST":
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

    public void searchFragment() {
        replaceFragment(new SearchSchFragment());
    }

    public void selectFragment() {
        replaceFragment(new SelectSchFragment());
    }

    public void setFragment() {
        replaceFragment(new SetClsFragment());
    }

    protected void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_set, fragment).commit();
    }

    public void onNextSet() {
        if (Objects.equals(getIntent().getStringExtra("TYPE"), "FIRST")) {
            startActivity(new Intent(getApplication(), MainActivity.class));
            finish();
        } else {
            finish();
        }
    }
}
