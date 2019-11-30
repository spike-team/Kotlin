package com.tistory.dsmparkyoungjin.studentable.data;

public class StudentData {

    private String deviceToken;

    private String schoolCode;

    private String schoolClass;

    private String email;

    public StudentData(String deviceToken, String schoolCode, String schoolClass, String email) {
        this.deviceToken = deviceToken;
        this.schoolCode = schoolCode;
        this.schoolClass = schoolClass;
        this.email = email;
    }
}
