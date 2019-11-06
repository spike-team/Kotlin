package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.select;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import java.util.List;

public interface SelectSchContract {

    interface View {

        void initView();

        void onNextSelect();

        void setItems(List<SchoolData> items);

        void notFound();
    }

    interface Presenter {

        void init(View view);

        void findSchool();
    }
}