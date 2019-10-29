package com.tistory.dsmparkyoungjin.studentable.presentation.ui.splash;

public interface SplashContract {

    interface View {

        void initView();

        String getGoogleAuth();
    }

    interface Presenter {

        void init(View view);

        Boolean isSet();

        void setGoogleAuth();
    }
}
