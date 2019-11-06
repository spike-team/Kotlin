package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.select;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepositoryImpl;

import io.reactivex.android.schedulers.AndroidSchedulers;
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
        findSchool();
    }

    @SuppressLint("CheckResult")
    @Override
    public void findSchool() {
        mRepository.findSchool()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        result -> {
                            if (result == null) mView.showToastForNotFound();
                            else mView.setItems(result);
                        },
                        error -> mView.showToastForNotConnectInternet()
                );
    }

    @Override
    public void select() {
        SchoolData selectedItem = mView.getSelectedItem();
        if (selectedItem != null) {
            mRepository.setSchool(mView.getSelectedItem());
            mView.onNextSelect();
        }
        else
            mView.notSelected();
    }
}
