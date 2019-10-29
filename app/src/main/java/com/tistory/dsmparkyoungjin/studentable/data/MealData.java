package com.tistory.dsmparkyoungjin.studentable.data;

import androidx.annotation.Nullable;

import java.util.List;

public class MealData {

    private String date;
    private List<String> breakfast;
    private List<String> lunch;
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
}
