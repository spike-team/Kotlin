package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.time;

import io.realm.RealmList;

public interface TimeContract {

    interface View {

        void initView();

        void visibleProgress();

        void invisibleProgress();

        void setItem(RealmList<String> items);

        void showToastForError();

        void showToastForStrangeData();

        void showToastForNotFound();
    }

    interface Presenter {

        void init(View view);

        void findTimes();
    }
}
