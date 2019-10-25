package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.domain.local.SplashPrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SplashPrefHelperImpl;

public class SplashRepositoryImpl implements SplashRepository {

    private SplashPrefHelper mPrefHelper;

    public SplashRepositoryImpl(Context context) {
        mPrefHelper = new SplashPrefHelperImpl(context);
    }

    @Override
    public Boolean isSet() {
        return mPrefHelper.isSet();
    }

    @Override
    public void setGoogleAuth(String mGoogleEmail) {
        mPrefHelper.setGoogleAuth(mGoogleEmail);
    }
}
