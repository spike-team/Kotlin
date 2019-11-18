package com.tistory.dsmparkyoungjin.studentable.presentation.ui.splash;

import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepositoryImpl;

public class SplashPresenter implements SplashContract.Presenter {

    private SetRepository mRepository;
    private SplashContract.View mView;

    SplashPresenter(Context context) {
        mRepository = new SetRepositoryImpl(context);
    }

    @Override
    public void init(SplashContract.View view) {
        mView = view;
        mView.initView();
    }

    @Override
    public Boolean isSet() {
        return mRepository.isSet();
    }

    @Override
    public void setGoogleAuth() {
        mRepository.setGoogleAuth(mView.getGoogleAuth());
    }
}
