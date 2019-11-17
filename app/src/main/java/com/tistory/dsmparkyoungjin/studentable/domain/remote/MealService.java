package com.tistory.dsmparkyoungjin.studentable.domain.remote;

import com.tistory.dsmparkyoungjin.studentable.data.MealResultData;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {
    @GET("meal")
    Flowable<Response<MealResultData>> findMeal(@Query("date") String date, @Query("school_code") String schoolCode);
}
