package com.tistory.dsmparkyoungjin.studentable.domain.local;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

public interface SetPrefHelper {

    void setSearch(String search);

    String getSearch();

    String getSchoolName();

    String getSchoolCode();

    void setSchool(SchoolData mSchoolData);

    void setGradeNo(int gradeNo);

    void setClassNo(int classNo);

    void saveAll();
}
