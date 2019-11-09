package com.tistory.dsmparkyoungjin.studentable.domain.remote;

import com.tistory.dsmparkyoungjin.studentable.data.MealData;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {
    @GET("meal")
    Flowable<Response<MealData>> findMeal(@Query("date") String date, @Query("schoolCode") String schoolCode);
}
