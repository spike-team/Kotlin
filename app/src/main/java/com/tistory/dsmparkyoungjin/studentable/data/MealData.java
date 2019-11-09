package com.tistory.dsmparkyoungjin.studentable.data;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealData {

    private String date;

    @SerializedName("breakfast")
    private List<String> breakfast;

    @SerializedName("lunch")
    private List<String> lunch;

    @SerializedName("dinner")
    private List<String> dinner;

    public MealData(String date, List<String> breakfast, List<String> lunch, List<String> dinner) {
        this.date = date;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public String getDate() {
        return date;
    }

    @Nullable
    public List<String> getBreakfast() {
        return breakfast;
    }

    @Nullable
    public List<String> getLunch() {
        return lunch;
    }

    @Nullable
    public List<String> getDinner() {
        return dinner;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
