package com.tistory.dsmparkyoungjin.studentable.domain.local;

import com.tistory.dsmparkyoungjin.studentable.data.MealResultData;

import io.realm.Realm;

public class MealDaoImpl implements MealDao {

    private Realm mRealm = Realm.getDefaultInstance();

    @Override
    public void setCache(MealResultData data) {
        mRealm.beginTransaction();
        mRealm.copyToRealm(data);
        mRealm.commitTransaction();
    }

    @Override
    public MealResultData getCache(String date) {
        return mRealm.where(MealResultData.class).equalTo("date", date).findFirst();
    }
}