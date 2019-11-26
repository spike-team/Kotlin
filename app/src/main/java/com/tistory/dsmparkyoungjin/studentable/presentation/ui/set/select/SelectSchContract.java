package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.select;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import java.util.List;

public interface SelectSchContract {

    interface View {

        void initView();

        void setItems(List<SchoolData> items);

        void visibleProgress();

        void invisibleProgress();

        void showToastForNotFound();

        void showToastForNotConnectInternet();

        SchoolData getSelectedItem();

        void onNextSelect();

        void notSelected();
    }

    interface Presenter {

        void init(View view);

        void findSchool();

        void select();
    }
}