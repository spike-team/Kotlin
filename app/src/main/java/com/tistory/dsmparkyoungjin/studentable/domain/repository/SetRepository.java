package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import io.reactivex.Flowable;

public interface SetRepository {

    Flowable<SchoolData> findSchool(String mSchoolName);

    void setSchool(SchoolData mSchoolData);

    void setGradeNo(int gradeNo);

    void setClassNo(int classNo);

    void saveAll();
}
