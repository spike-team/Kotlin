package com.tistory.dsmparkyoungjin.studentable.presentation.ui.splash;

import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.tistory.dsmparkyoungjin.domain.usecase.SetUseCase;
import com.tistory.dsmparkyoungjin.studentable.presentation.ui.base.BasePresenter;

import io.reactivex.disposables.CompositeDisposable;

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    private SetUseCase mSetUseCase;

    private SplashContract.View mView;

    public SplashPresenter(CompositeDisposable composite, SetUseCase setUsecase) {
        super(composite);
        mSetUseCase = setUsecase;
    }

    @Override
    public void splash() {
        googleLogin();
        if (mSetUseCase.isSet())    mView.startMainActivity();
        else                        mView.startSettingActivity();
    }

    @Override
    public void googleLogin() {
        GoogleSignInOptions mGSIO = getGoogleSignInOptions();
        Log.d("Asdf", "googleLogin: " + mGSIO.getAccount());
    }

    private GoogleSignInOptions getGoogleSignInOptions() {
        return new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("AAAA8I_Gkm0:APA91bFnMzVzzFzEcxd7zhYuun26j3iPq-KqzrzOB7wcKU5-zVLZ7Q8aJzp7MqyYhW71If6Q7fp6PhP52fAajpEWApNXCBAB4_cUybjOkDo27SPusvxXftYDBUV23P5zZiMuTsFCrevF")
                .requestEmail()
                .build();
    }

    @Override
    public void createView(SplashContract.View mView) {
        super.createView(mView);
        this.mView = mView;
    }

    @Override
    public void destroyView() {
        super.destroyView();
    }
}
