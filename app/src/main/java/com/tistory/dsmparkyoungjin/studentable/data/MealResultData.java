package com.tistory.dsmparkyoungjin.studentable.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealResultData {

    private String code;

    private String date;

    @SerializedName("menus")
    private List<MealData> result;

    public MealResultData(String code, String date, List<MealData> result) {
        this.code = code;
        this.date = date;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public MealResultData date(String date) {
        this.date = date;
        return this;
    }

    List<MealData> getResult() {
        return result;
    }
}
