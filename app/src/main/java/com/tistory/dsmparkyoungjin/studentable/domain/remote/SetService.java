package com.tistory.dsmparkyoungjin.studentable.domain.remote;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SetService {
    @GET("/school?key={key}")
    Flowable<SchoolData> findSchool(@Path("key") String key);
}
