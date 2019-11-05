package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.search;

public interface SearchSchContract {

    interface View {

        void initView();

        void showToastForLackWord();

        void showToastForNotFound();

        void onNextSearch();

        String getSchoolName();
    }

    interface Presenter {

        void init(View view);

        void findSchool();
    }
}
