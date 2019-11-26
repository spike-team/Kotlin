package com.tistory.dsmparkyoungjin.studentable.domain.local;

import com.tistory.dsmparkyoungjin.studentable.data.MealResultData;
import com.tistory.dsmparkyoungjin.studentable.data.MealResultRealm;

public interface MealDao {

    void setCache(MealResultData data);

    MealResultRealm getCache(String date, String code);
}
