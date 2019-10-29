package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.base;

public interface MainContract {

    interface View {

        void initView();
    }

    interface Presenter {

        void init(View view);

        String getActionBarTitle();

        String getRecentView();

        void setRecentViewTime();

        void setRecentViewMeal();
    }

}
