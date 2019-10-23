package com.tistory.dsmparkyoungjin.studentable.domain.repository;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

public interface SetRepository {

    void setSchool(SchoolData mSchoolData);

    void setGradeNo(int gradeNo);

    void setClassNo(int classNo);

    void saveAll();
}
