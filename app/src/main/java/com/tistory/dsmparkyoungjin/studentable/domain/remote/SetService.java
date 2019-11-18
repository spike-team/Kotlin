package com.tistory.dsmparkyoungjin.studentable.domain.remote;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface SetService {
    @GET("school")
    Flowable<Response<List<SchoolData>>> findSchool(@Query("key") String key);

    @PUT("student")
    Flowable<Response<Completable>> setStudent(
            @Field("email") String email,
            @Field("deviceToken") String deviceToken,
            @Field("schoolCode") String schoolCode,
            @Field("schoolClass") String schoolClass
    );
}
