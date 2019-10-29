package com.tistory.dsmparkyoungjin.studentable.presentation.ui.notice;

import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.domain.local.NoticePrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.NoticePrefHelperImpl;

public class NoticePresenter implements NoticeContract.Presenter {

    private NoticeContract.View mView;

    private NoticePrefHelper mPrefHelper;

    NoticePresenter(Context context) {
        mPrefHelper = new NoticePrefHelperImpl(context);
    }

    @Override
    public void init(NoticeContract.View view) {
        mView = view;
        mView.initView();
    }

    @Override
    public Boolean isEnable() {
        return mPrefHelper.isEnable();
    }

    @Override
    public void setEnable() {
        mPrefHelper.setEnable();
    }

    @Override
    public void setDisable() {
        mPrefHelper.setDisable();
    }
}
