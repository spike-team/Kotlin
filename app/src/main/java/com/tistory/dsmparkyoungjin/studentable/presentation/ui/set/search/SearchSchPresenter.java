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

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    @Override
    public void findSchool() {
        String search = mView.getSchoolName();
        if (search.length() >= 3) {
            mRepository.findSchool(search).subscribe(
                    result -> {
                        mRepository.setSchool(result);
                        mView.onNextSearch();
                    },
                    error -> mView.showToastForNotFound()
            );
        } else {
            mView.showToastForLackWord();
        }
    }
}
