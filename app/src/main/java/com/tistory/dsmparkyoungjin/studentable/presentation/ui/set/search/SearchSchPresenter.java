package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.search;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepositoryImpl;

public class SearchSchPresenter implements SearchSchContract.Presenter {

    private SearchSchContract.View mView;
    private SetRepository mRepository;

    SearchSchPresenter(Context context) {
        mRepository = new SetRepositoryImpl(context);
    }

    @Override
    public void init(SearchSchContract.View view) {
        mView = view;
        mView.initView();
    }

    @SuppressLint("CheckResult")
    @Override
    public void search() {
        String search = mView.getSchoolName();
        if (search.length() >= 3) {
            mRepository.setSearch(search);
            mView.onNextSearch();
        } else {
            mView.showToastForLackWord();
        }
    }
}
