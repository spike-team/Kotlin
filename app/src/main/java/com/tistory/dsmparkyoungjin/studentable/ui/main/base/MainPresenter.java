package com.tistory.dsmparkyoungjin.studentable.ui.main.base;

import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.domain.local.MainPrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.MainPrefHelperImpl;

class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    private MainPrefHelper mPrefHelper;

    MainPresenter(Context context) {
        mPrefHelper = new MainPrefHelperImpl(context);
    }

    @Override
    public void init(MainContract.View view) {
        mView = view;
        mView.initView();
    }

    @Override
    public String getActionBarTitle() {
        return mPrefHelper.getSchoolName() + " "
                + mPrefHelper.getGradeNo() + "학년 "
                + mPrefHelper.getClassNo() + "반";
    }

    @Override
    public String getRecentView() {
        return mPrefHelper.getRecentView();
    }

    @Override
    public void setRecentViewTime() {
        mPrefHelper.setRecentView(MainPrefHelperImpl.TIME);
    }

    @Override
    public void setRecentViewMeal() {
        mPrefHelper.setRecentView(MainPrefHelperImpl.MEAL);
    }
}
