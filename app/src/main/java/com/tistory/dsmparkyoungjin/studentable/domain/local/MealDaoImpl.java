package com.tistory.dsmparkyoungjin.studentable.domain.local;

import android.util.Log;

import com.tistory.dsmparkyoungjin.studentable.data.MealMapper;
import com.tistory.dsmparkyoungjin.studentable.data.MealResultData;
import com.tistory.dsmparkyoungjin.studentable.data.MealResultRealm;

import io.realm.Realm;

public class MealDaoImpl implements MealDao {

    private Realm mRealm = Realm.getDefaultInstance();

    @Override
    public void setCache(MealResultData data) {
        Log.d("TT", "setCache: " + data.getCode());
        mRealm.beginTransaction();
        mRealm.copyToRealm(MealMapper.toMealResultRealm(data));
        mRealm.commitTransaction();
    }

    @Override
    public MealResultRealm getCache(String date, String code) {
        return mRealm.where(MealResultRealm.class)
                .equalTo("code", code)
                .equalTo("date", date)
                .findFirst();
    }
}