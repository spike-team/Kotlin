package com.tistory.dsmparkyoungjin.studentable.domain.local;

import com.tistory.dsmparkyoungjin.studentable.data.TimeData;
import com.tistory.dsmparkyoungjin.studentable.data.TimeMapper;
import com.tistory.dsmparkyoungjin.studentable.data.TimeRealm;

import io.realm.Realm;

public class TimeDaoImpl implements TimeDao {

    private Realm mRealm = Realm.getDefaultInstance();

    @Override
    public void setCache(TimeData data) {
        mRealm.beginTransaction();
        mRealm.copyToRealm(TimeMapper.toTimeRealm(data));
        mRealm.commitTransaction();
    }

    @Override
    public TimeRealm getCache(String schoolClass, String schoolCode) {
        return mRealm.where(TimeRealm.class)
                .equalTo("schoolClass", schoolClass)
                .equalTo("schoolCode", schoolCode)
                .findFirst();
    }
}
