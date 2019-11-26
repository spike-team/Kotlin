package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.select;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepositoryImpl;

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
        mView.visibleProgress();
        mRepository.findSchool()
                .doOnSubscribe(notUsed -> mView.visibleProgress())
                .doOnTerminate(() -> mView.invisibleProgress())
                .subscribe(
                        response -> {
                            switch (response.code()) {
                                case 200:
                                    mView.setItems(response.body());    break;
                                case 404:
                                    mView.showToastForNotFound();       break;
                            }
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
