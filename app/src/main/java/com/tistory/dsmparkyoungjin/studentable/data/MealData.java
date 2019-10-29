package com.tistory.dsmparkyoungjin.studentable.data;

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

    public List<String> getBreakfast() {
        return breakfast;
    }

    public List<String> getLunch() {
        return lunch;
    }

    public List<String> getDinner() {
        return dinner;
    }
}
