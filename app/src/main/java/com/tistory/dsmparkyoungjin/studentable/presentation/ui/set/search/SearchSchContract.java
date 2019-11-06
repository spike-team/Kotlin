package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.search;

public interface SearchSchContract {

    interface View {

        void initView();

        void showToastForLackWord();

        void onNextSearch();

        String getSchoolName();
    }

    interface Presenter {

        void init(View view);

        void search();
    }
}
