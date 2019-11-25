package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.meal;

import com.tistory.dsmparkyoungjin.studentable.data.MealRealm;

import io.realm.RealmList;

public interface MealContract {

    interface View {

        void initView();

        void setItem(RealmList<MealRealm> items);

        void showToastForError();

        void showToastForStrangeData();

        void showToastForNotFound();
    }

    interface Presenter {

        void init(View view);

        void findMeals();
    }
}
