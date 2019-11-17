package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal;

import com.tistory.dsmparkyoungjin.studentable.data.MealData;

import java.util.List;

public interface MealContract {

    interface View {

        void initView();

        void setItem(List<MealData> items);

        void showToastForError();

        void showToastForStrangeData();

        void showToastForNotFound();
    }

    interface Presenter {

        void init(View view);

        void findMeals();
    }
}
