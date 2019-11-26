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

    public MealResultData code(String code) {
        this.code = code;
        return this;
    }

    public MealResultData list(List<MealData> list) {
        this.result = list;
        return this;
    }

    public List<MealData> getResult() {
        return result;
    }
}
