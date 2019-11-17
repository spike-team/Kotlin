package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelperImpl;
import com.tistory.dsmparkyoungjin.studentable.domain.remote.SetService;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class SetRepositoryImpl implements SetRepository {

    private SetPrefHelper mPrefHelper;
    private SetService mService;

    public SetRepositoryImpl(Context context) {
        mPrefHelper = new SetPrefHelperImpl(context);
        mService = new Retrofit.Builder()
                .baseUrl("http://studentable.jaehoon.kim/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(SetService.class);
    }

    @Override
    public void setSearch(String search) {
        mPrefHelper.setSearch(search);
    }

    @Override
    public String getSearch() {
        return mPrefHelper.getSearch();
    }

    @Override
    public String getSchoolName() {
        return mPrefHelper.getSchoolName();
    }

    @Override
    public Flowable<Response<List<SchoolData>>> findSchool() {
        return mService.findSchool(mPrefHelper.getSearch());
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
