package com.tistory.dsmparkyoungjin.studentable.ui.splash;

public interface SpalshContract {

    interface View {

        void initView();

        String getGoogleAuth();
    }

    interface Presenter {

        void init(SpalshContract.View view);

        Boolean isSet();

        void setGoogleAuth();

        void setDeviceCode();
    }
}
