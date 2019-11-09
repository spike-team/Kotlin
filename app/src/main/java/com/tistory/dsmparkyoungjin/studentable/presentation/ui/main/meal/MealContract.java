package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal;

import com.tistory.dsmparkyoungjin.studentable.data.MealData;

import java.util.List;

public interface MealContract {

    interface View {

        void initView();

        void setItem(List<MealData> items);
    }

    interface Presenter {

        void init(View view);

        List<MealData> findMeals();
    }
}
