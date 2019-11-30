package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.data.TimeData;
import com.tistory.dsmparkyoungjin.studentable.data.TimeRealm;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelperImpl;
import com.tistory.dsmparkyoungjin.studentable.domain.local.TimeDao;
import com.tistory.dsmparkyoungjin.studentable.domain.local.TimeDaoImpl;
import com.tistory.dsmparkyoungjin.studentable.domain.remote.TimeService;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class TimeRepositoryImpl implements TimeRepository {

    private SetPrefHelper mPrefHelper;
    private TimeService mService;
    private TimeDao mDao;

    public TimeRepositoryImpl(Context context) {
        mPrefHelper = new SetPrefHelperImpl(context);
        mService = new Retrofit.Builder()
                .baseUrl("http://studentable.jaehoon.kim/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(TimeService.class);
        mDao = new TimeDaoImpl();
    }

    @Override
    public boolean isExist() {
        return mDao.getCache(
                (mPrefHelper.getGradeNo() + "-" + mPrefHelper.getClassNo()),
                mPrefHelper.getSchoolCode()
        ) != null;
    }

    @Override
    public TimeRealm getTimes() {
        return mDao.getCache(
                (mPrefHelper.getGradeNo() + "-" + mPrefHelper.getClassNo()),
                mPrefHelper.getSchoolCode()
        );
    }

    @Override
    public void cache(TimeData data) {
        mDao.setCache(data);
    }

    @Override
    public Flowable<Response<TimeData>> findTimes() {
        return mService.findTimes(
                mPrefHelper.getSchoolCode(),
                (mPrefHelper.getGradeNo() + "-" + mPrefHelper.getClassNo())
        ).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
    }
}
