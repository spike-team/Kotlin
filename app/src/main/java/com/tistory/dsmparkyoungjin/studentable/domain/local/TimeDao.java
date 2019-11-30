package com.tistory.dsmparkyoungjin.studentable.domain.local;

import com.tistory.dsmparkyoungjin.studentable.data.TimeData;
import com.tistory.dsmparkyoungjin.studentable.data.TimeRealm;

public interface TimeDao {

    void setCache(TimeData data);

    TimeRealm getCache(String schoolClass, String schoolCode);
}
