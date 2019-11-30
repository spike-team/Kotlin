package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import retrofit2.Response;

public interface SetRepository {

    Boolean isSet();

    String getGoogleAuth();

    void setGoogleAuth(String mGoogleAuth);

    String getDeviceToken();

    void setDeviceToken(String mDeviceToken);

    void setSearch(String search);

    String getSearch();

    String getSchoolName();

    Flowable<Response<List<SchoolData>>> findSchool();

    void setSchool(SchoolData mSchoolData);

    void setGradeNo(int gradeNo);

    void setClassNo(int classNo);

    void saveAll();

    Flowable<Response<Completable>> setStudent(String deviceToken);
}
