package com.tistory.dsmparkyoungjin.studentable.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MealData {

    private String day;

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

    String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    List<String> getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(List<String> breakfast) {
        this.breakfast = breakfast;
    }

    List<String> getLunch() {
        return lunch;
    }

    public void setLunch(List<String> lunch) {
        this.lunch = lunch;
    }

    List<String> getDinner() {
        return dinner;
    }

    public void setDinner(List<String> dinner) {
        this.dinner = dinner;
    }
}
