package com.tistory.dsmparkyoungjin.studentable.presentation.ui.notice;

public interface NoticeContract {

    interface View {

        void initView();
    }

    interface Presenter {

        void init(View view);

        Boolean isEnable();

        void setEnable();

        void setDisable();
    }
}
