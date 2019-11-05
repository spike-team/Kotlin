package com.tistory.dsmparkyoungjin.studentable.domain.remote;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SetService {
    @GET("/school")
    Flowable<SchoolData> findSchool(@Query("key") String key);
}
