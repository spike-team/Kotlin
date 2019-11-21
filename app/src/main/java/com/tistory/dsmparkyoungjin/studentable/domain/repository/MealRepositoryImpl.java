package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import android.content.Context;

import com.tistory.dsmparkyoungjin.studentable.data.MealResultData;
import com.tistory.dsmparkyoungjin.studentable.domain.local.MealDao;
import com.tistory.dsmparkyoungjin.studentable.domain.local.MealDaoImpl;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelper;
import com.tistory.dsmparkyoungjin.studentable.domain.local.SetPrefHelperImpl;
import com.tistory.dsmparkyoungjin.studentable.domain.remote.MealService;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealRepositoryImpl implements MealRepository {

    private SetPrefHelper mPrefHelper;
    private MealService mService;
    private MealDao mDao;

    public MealRepositoryImpl(Context context) {
        mPrefHelper = new SetPrefHelperImpl(context);
        mService = new Retrofit.Builder()
                .baseUrl("http://studentable.jaehoon.kim/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(MealService.class);
        mDao = new MealDaoImpl();
    }

    @Override
    public Flowable<Response<MealResultData>> findMeal(String date) {
        return mService.findMeal(date, mPrefHelper.getSchoolCode());
    }
}
