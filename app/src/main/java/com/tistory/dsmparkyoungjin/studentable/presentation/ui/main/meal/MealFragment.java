package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.tistory.dsmparkyoungjin.studentable.R;
import com.tistory.dsmparkyoungjin.studentable.data.MealData;
import com.tistory.dsmparkyoungjin.studentable.presentation.adapter.MealAdapter;

import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

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
    public void setItem(List<MealData> items) {
        MealAdapter adapter = new MealAdapter(items);

        ViewPager2 viewpager = mCurrentView.findViewById(R.id.vp_meal);
        viewpager.setAdapter(adapter);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        CircleIndicator3 circleIndicator = mCurrentView.findViewById(R.id.ci_date);
        circleIndicator.createIndicators(7, 0);
        circleIndicator.setViewPager(viewpager);

        adapter.registerAdapterDataObserver(circleIndicator.getAdapterDataObserver());
    }
}