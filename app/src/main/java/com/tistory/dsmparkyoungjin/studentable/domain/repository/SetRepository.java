package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

import java.util.List;

import io.reactivex.Flowable;

public interface SetRepository {

    void setSearch(String search);

    String getSearch();

    Flowable<List<SchoolData>> findSchool();

    void setSchool(SchoolData mSchoolData);

    void setGradeNo(int gradeNo);

    void setClassNo(int classNo);

    void saveAll();
}
