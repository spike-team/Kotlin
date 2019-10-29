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

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

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
        ArrayList<MealData> items = new ArrayList<>();

        List<String> breakfast = new ArrayList<>();
        List<String> lunch = new ArrayList<>();
        List<String> dinner = new ArrayList<>();

        breakfast.add("간장계란밥");
        breakfast.add("시금치된장국");
        lunch.add("흰밥");
        lunch.add("북어감자국");
        dinner.add("현미밥");
        dinner.add("유부김치국");

        items.add(new MealData("10월 28일", breakfast, lunch, dinner));
        items.add(new MealData("10월 29일", breakfast, lunch, dinner));
        items.add(new MealData("10월 30일", breakfast, lunch, dinner));
        items.add(new MealData("10월 31일", breakfast, lunch, null));
        items.add(new MealData("11월 1일", null, null, null));

        MealAdapter adapter = new MealAdapter(items);

        ViewPager2 viewpager = view.findViewById(R.id.vp_meal);
        viewpager.setAdapter(adapter);
        viewpager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        CircleIndicator3 circleIndicator = view.findViewById(R.id.ci_date);
        circleIndicator.createIndicators(5, 0);
        circleIndicator.setViewPager(viewpager);

        adapter.registerAdapterDataObserver(circleIndicator.getAdapterDataObserver());
    }
}
