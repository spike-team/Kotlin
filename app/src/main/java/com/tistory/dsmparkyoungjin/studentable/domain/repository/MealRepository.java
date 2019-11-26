package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import com.tistory.dsmparkyoungjin.studentable.data.MealResultData;
import com.tistory.dsmparkyoungjin.studentable.data.MealResultRealm;

import io.reactivex.Flowable;
import retrofit2.Response;

public interface MealRepository {

    boolean isExist(String date);

    MealResultRealm getMeals(String date);

    void cache(MealResultData data);

    Flowable<Response<MealResultData>> findMeals(String date);
}