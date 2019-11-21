package com.tistory.dsmparkyoungjin.studentable.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MealResultData extends RealmObject {

    @PrimaryKey
    private String code;

    private String date;

    @SerializedName("menus")
    private List<MealData> result;

    public List<MealData> getResult() {
        return result;
    }

    public void setResult(List<MealData> result) {
        this.result = result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
