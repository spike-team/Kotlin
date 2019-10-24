package com.tistory.dsmparkyoungjin.studentable.ui.splash;

public interface SplashContract {

    interface View {

        void initView();

        String getGoogleAuth();
    }

    interface Presenter {

        void init(View view);

        Boolean isSet();

        void setGoogleAuth();

        void setDeviceCode();
    }
}
