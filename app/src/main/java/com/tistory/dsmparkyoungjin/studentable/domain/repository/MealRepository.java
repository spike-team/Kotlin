package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import com.tistory.dsmparkyoungjin.studentable.data.MealResultData;

import io.reactivex.Flowable;
import retrofit2.Response;

public interface MealRepository {

    Flowable<Response<MealResultData>> findMeal(String date);
}
