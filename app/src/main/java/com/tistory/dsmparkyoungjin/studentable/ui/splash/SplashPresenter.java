package com.tistory.dsmparkyoungjin.studentable.ui.splash;

import android.content.Context;

import com.google.firebase.iid.FirebaseInstanceId;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SplashRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SplashRepositoryImpl;

import java.util.Objects;

public class SplashPresenter implements SpalshContract.Presenter {

    private SplashRepository mRepository;
    private SpalshContract.View mView;

    SplashPresenter(Context context) {
        mRepository = new SplashRepositoryImpl(context);
    }

    @Override
    public void init(SpalshContract.View view) {
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

    @Override
    public void setDeviceCode() {
        FirebaseInstanceId.getInstance()
                .getInstanceId()
                .addOnCompleteListener(
                        task -> mRepository.setDeviceCode(Objects.requireNonNull(task.getResult()).getToken())
                );
    }
}
