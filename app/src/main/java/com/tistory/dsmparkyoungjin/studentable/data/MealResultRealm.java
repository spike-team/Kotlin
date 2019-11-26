package com.tistory.dsmparkyoungjin.studentable.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MealResultRealm extends RealmObject {

    @PrimaryKey
    private String code;
    private String date;

    private RealmList<MealRealm> list;


    public MealResultRealm() {
    }

    void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RealmList<MealRealm> getList() {
        return list;
    }

    public void setList(RealmList<MealRealm> list) {
        this.list = list;
    }
}
