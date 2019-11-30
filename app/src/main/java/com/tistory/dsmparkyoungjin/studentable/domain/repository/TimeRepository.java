package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import com.tistory.dsmparkyoungjin.studentable.data.TimeData;
import com.tistory.dsmparkyoungjin.studentable.data.TimeRealm;

import io.reactivex.Flowable;
import retrofit2.Response;

public interface TimeRepository {

    boolean isExist();

    TimeRealm getTimes();

    void cache(TimeData data);

    Flowable<Response<TimeData>> findTimes();
}
