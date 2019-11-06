package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.select;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepositoryImpl;

import io.reactivex.schedulers.Schedulers;

public class SelectSchPresenter implements SelectSchContract.Presenter {

    private SelectSchContract.View mView;
    private SetRepository mRepository;

    SelectSchPresenter(Context context) {
        mRepository = new SetRepositoryImpl(context);
    }

    @Override
    public void init(SelectSchContract.View view) {
        mView = view;
        mView.initView();
    }

    @SuppressLint({"CheckResult", "Assert"})
    @Override
    public void findSchool() {
        mRepository.findSchool()
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.newThread())
                .subscribe(
                        result -> mView.setItems(result),
                        error -> mView.notFound()
                );
    }
}
