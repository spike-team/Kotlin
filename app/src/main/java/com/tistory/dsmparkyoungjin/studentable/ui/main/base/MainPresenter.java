package com.tistory.dsmparkyoungjin.studentable.ui.main.base;

class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mView.initView();
    }
}
