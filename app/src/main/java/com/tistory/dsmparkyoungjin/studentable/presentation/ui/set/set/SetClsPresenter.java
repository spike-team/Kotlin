package com.tistory.dsmparkyoungjin.studentable.presentation.ui.set.set;

import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepository;
import com.tistory.dsmparkyoungjin.studentable.domain.repository.SetRepositoryImpl;

public class SetClsPresenter implements SetClsContract.Presenter {

    private SetClsContract.View mView;
    private SetRepository mRepository;

    SetClsPresenter(Context context) {
        mRepository = new SetRepositoryImpl(context);
    }

    @Override
    public void init(SetClsContract.View view) {
        mView = view;
        mView.initView();
        mView.setSchoolName(mRepository.getSchoolName());
    }

    @Override
    public void save() {
        mRepository.setGradeNo(mView.getGradeNo());
        mRepository.setClassNo(mView.getClassNo());
        mRepository.saveAll();
        mView.onNextSave();
    }
}