package com.tistory.dsmparkyoungjin.studentable.presentation.ui.main.time;

import android.annotation.SuppressLint;
import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.domain.repository.TimeRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.TimeRepositoryImpl;

public class TimePresenter implements TimeContract.Presenter {

    private TimeContract.View mView;
    private TimeRepository mRepository;

    TimePresenter(Context context) {
        mRepository = new TimeRepositoryImpl(context);
    }

    @Override
    public void init(TimeContract.View view) {
        mView = view;
        mView.initView();
        findTimes();
    }

    @SuppressLint("CheckResult")
    @Override
    public void findTimes() {
        if(mRepository.isExist()) {
            mView.visibleProgress();
            mView.setItem(mRepository.getTimes().getSubjects());
            mView.invisibleProgress();
        } else {
            mRepository.findTimes()
                    .doOnSubscribe(notUsed -> mView.visibleProgress())
                    .doOnTerminate(() -> mView.invisibleProgress())
                    .subscribe(
                            response -> {
                                switch (response.code()) {
                                    case 200:
                                        mRepository.cache(response.body());
                                        mView.setItem(mRepository.getTimes().getSubjects());
                                        break;
                                    case 400:
                                        mView.showToastForStrangeData();
                                        break;
                                    case 404:
                                        mView.showToastForNotFound();
                                        break;
                                    default:
                                        mView.showToastForError();
                                }
                            },
                            error -> mView.showToastForError()
                    );
        }
    }
}
