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

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
