package com.tistory.dsmparkyoungjin.studentable.presentation.ui.base;

public interface BaseContract {

    interface View {

        void setPresenter(Presenter mPresenter);
    }

    interface Presenter<T> {

        void createView(T mView);

        void destroyView();
    }
}