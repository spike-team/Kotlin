package com.tistory.dsmparkyoungjin.studentable.data;

import com.google.gson.annotations.SerializedName;

public class SchoolData {

    @SerializedName("fullName")
    private String fullName;

    @SerializedName("name")
    private String name;

    @SerializedName("schoolCode")
    private String code;

    public SchoolData(String fullName, String name, String code) {
        this.fullName = fullName;
        this.name = name;
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
