package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.data.MealRealm;
import com.tistory.dsmparkyoungjin.studentable.presentation.adapter.MealAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import io.realm.RealmList;

public class MealFragment extends Fragment implements MealContract.View {

    private View mCurrentView;
    private MealContract.Presenter mPresenter;

    public MealFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mCurrentView = inflater.inflate(R.layout.fragment_meal, container, false);
        return mCurrentView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mPresenter = new MealPresenter(getContext());
        mPresenter.init(this);
    }

    @Override
    public void initView() {
    }

    @Override
    public void setItem(RealmList<MealRealm> items) {
        MealAdapter adapter = new MealAdapter(items);
        int todayIndex = Integer.parseInt(new SimpleDateFormat("dd", Locale.KOREA).format(new Date())) - 1;

        ViewPager2 viewpager = mCurrentView.findViewById(R.id.vp_meal);
        viewpager.setAdapter(adapter);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewpager.setCurrentItem(todayIndex);
    }

    @Override
    public void showToastForError() {
        Toast.makeText(getContext(), "급식을 불러올 수 없습니다", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToastForStrangeData() {
        Toast.makeText(getContext(), "학교 혹은 날짜가 잘못되었습니다. 설정을 확인해주세요", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showToastForNotFound() {
        Toast.makeText(getContext(), "서버에서 급식을 찾을 수 없습니다", Toast.LENGTH_SHORT).show();
    }
}