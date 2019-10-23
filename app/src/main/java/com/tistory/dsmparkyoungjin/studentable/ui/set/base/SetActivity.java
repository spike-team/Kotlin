package com.tistory.dsmparkyoungjin.studentable.ui.set.base;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.ui.set.search.SearchSchFragment;
import com.tistory.dsmparkyoungjin.studentable.ui.set.select.SelectSchFragment;
import com.tistory.dsmparkyoungjin.studentable.ui.set.set.SetClsFragment;

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
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container_set, fragment).commit();
    }
}
