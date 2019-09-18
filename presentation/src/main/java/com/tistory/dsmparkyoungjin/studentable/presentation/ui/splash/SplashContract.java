package com.tistory.dsmparkyoungjin.studentable.presentation.ui.splash;

import com.tistory.dsmparkyoungjin.studentable.presentation.ui.base.BaseContract;

public interface SplashContract {

    interface View extends BaseContract.View {

        void startMainActivity();

        void startSettingActivity();
    }

    interface Presenter extends BaseContract.Presenter<View> {

        void splash();

        void googleLogin();
    }
}
