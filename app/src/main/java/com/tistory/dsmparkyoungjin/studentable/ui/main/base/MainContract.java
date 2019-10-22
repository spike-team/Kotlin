package com.tistory.dsmparkyoungjin.studentable.ui.main.base;

public interface MainContract {

    interface View {

        void initView();
    }

    interface Presenter {

        void init();

        String getActionBarTitle();

        String getRecentView();

        void setRecentViewTime();

        void setRecentViewMeal();
    }

}
