package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import com.tistory.dsmparkyoungjin.studentable.data.MealData;

import io.reactivex.Flowable;
import retrofit2.Response;

public interface MealRepository {

    Flowable<Response<MealData>> findMeal(String date);
}
