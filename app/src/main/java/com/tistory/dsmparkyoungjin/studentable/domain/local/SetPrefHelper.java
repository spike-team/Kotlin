package com.tistory.dsmparkyoungjin.studentable.domain.local;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

public interface SetPrefHelper {

    Boolean isSet();

    void setGoogleAuth(String mGoogleAuth);

    void setSearch(String search);

    String getSearch();

    String getSchoolName();

    String getSchoolCode();

    void setSchool(SchoolData mSchoolData);

    void setGradeNo(int gradeNo);

    int getGradeNo();

    int getClassNo();

    void setClassNo(int classNo);

    void saveAll();
}
