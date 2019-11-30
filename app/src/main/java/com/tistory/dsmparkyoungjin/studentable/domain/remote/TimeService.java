package com.tistory.dsmparkyoungjin.studentable.domain.remote;

import com.tistory.dsmparkyoungjin.studentable.data.TimeData;

import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TimeService {

    @GET("timetable")
    Flowable<Response<TimeData>> findTimes(
            @Query("schoolCode") String schoolCode,
            @Query("schoolClass") String schoolClass
    );
}
