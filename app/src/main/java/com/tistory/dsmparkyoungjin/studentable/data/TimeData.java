package com.tistory.dsmparkyoungjin.studentable.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TimeData {

    @SerializedName("schoolCode")
    private String schoolCode;

    @SerializedName("schoolClass")
    private String schoolClass;

    @SerializedName("subjects")
    private List<String> subjects;

    public TimeData(String schoolCode, String schoolClass, List<String> subjects) {
        this.schoolCode = schoolCode;
        this.schoolClass = schoolClass;
        this.subjects = subjects;
    }

    String getSchoolCode() {
        return schoolCode;
    }

    String getSchoolClass() {
        return schoolClass;
    }

    List<String> getSubjects() {
        return subjects;
    }
}
