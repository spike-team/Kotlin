package com.tistory.dsmparkyoungjin.studentable.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealResultData {

    @SerializedName("menus")
    private List<MealData> result;

    public MealResultData(List<MealData> result) {
        this.result = result;
    }

    public List<MealData> getResult() {
        return result;
    }

    public void setResult(List<MealData> result) {
        this.result = result;
    }
}
