package com.tistory.dsmparkyoungjin.studentable.domain.remote;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;
import com.tistory.dsmparkyoungjin.studentable.data.StudentData;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface SetService {
    @GET("school")
    Flowable<Response<List<SchoolData>>> findSchool(@Query("key") String key);

    @POST("student")
    Flowable<Response<Completable>> postStudent(@Body StudentData student);

    @PUT("student")
    Flowable<Response<Completable>> putStudent(@Body StudentData student);
}
