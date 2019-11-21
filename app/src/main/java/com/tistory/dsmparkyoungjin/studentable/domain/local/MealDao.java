package com.tistory.dsmparkyoungjin.studentable.domain.local;

import com.tistory.dsmparkyoungjin.studentable.data.MealResultData;

public interface MealDao {

    void setCache(MealResultData data);

    MealResultData getCache(String date);
}
