package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.set;

public interface SetClsContract {

    interface View {

        void initView();

        void setSchoolName(String name);

        int getGradeNo();

        int getClassNo();

        void showToastForSetNumber();

        void onNextSave();

    }

    interface Presenter {

        void init(View view);

        void save();
    }
}
