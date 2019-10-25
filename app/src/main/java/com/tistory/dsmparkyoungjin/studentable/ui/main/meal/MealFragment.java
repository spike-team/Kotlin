package com.tistory.dsmparkyoungjin.studentable.ui.main.meal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.tistory.dsmparkyoungjin.studentable.R;

import me.relex.circleindicator.CircleIndicator;

public class MealFragment extends Fragment {

    public MealFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        CircleIndicator circleIndicator = view.findViewById(R.id.ci_date);
        circleIndicator.createIndicators(5, 0);

        ViewPager2 viewpager = view.findViewById(R.id.vp_meal);
    }
}
