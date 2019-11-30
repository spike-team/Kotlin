package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;

public interface SetRepository {

    Boolean isSet();

    void setGoogleAuth(String mGoogleAuth);

    void setDeviceToken(String mDeviceToken);

    void setSearch(String search);

    String getSchoolName();

    Flowable<Response<List<SchoolData>>> findSchool();

    void setSchool(SchoolData mSchoolData);

    void setGradeNo(int gradeNo);

    void setClassNo(int classNo);

    void saveAll();

    Flowable<Response<Void>> setStudent();
}
