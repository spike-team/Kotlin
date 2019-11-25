package com.tistory.dsmparkyoungjin.studentable.data;

import io.realm.RealmList;
import io.realm.RealmObject;

public class MealRealm extends RealmObject {

    private String day;

    private String date;

    private RealmList<String> breakfast;

    private RealmList<String> lunch;

    private RealmList<String> dinner;

    public MealRealm() {
    }

    public MealRealm(String day, String date, RealmList<String> breakfast, RealmList<String> lunch, RealmList<String> dinner) {
        this.day = day;
        this.date = date;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
    }

    public String getDay() {
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

    public RealmList<String> getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(RealmList<String> breakfast) {
        this.breakfast = breakfast;
    }

    public RealmList<String> getLunch() {
        return lunch;
    }

    public void setLunch(RealmList<String> lunch) {
        this.lunch = lunch;
    }

    public RealmList<String> getDinner() {
        return dinner;
    }

    public void setDinner(RealmList<String> dinner) {
        this.dinner = dinner;
    }
}
