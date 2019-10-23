package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelperImpl;

public class SetRepositoryImpl implements SetRepository {

    private SetPrefHelper mPrefHelper;

    public SetRepositoryImpl(Context context) {
        mPrefHelper = new SetPrefHelperImpl(context);
    }

    @Override
    public void setSchool(SchoolData mSchoolData) {
        mPrefHelper.setSchool(mSchoolData);
    }

    @Override
    public void setGradeNo(int gradeNo) {
        mPrefHelper.setGradeNo(gradeNo);
    }

    @Override
    public void setClassNo(int classNo) {
        mPrefHelper.setClassNo(classNo);
    }

    @Override
    public void saveAll() {
        mPrefHelper.saveAll();
    }
}
