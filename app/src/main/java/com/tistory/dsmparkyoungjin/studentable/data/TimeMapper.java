package com.tistory.dsmparkyoungjin.studentable.data;

import io.realm.RealmList;

public class TimeMapper {

    public static TimeRealm toTimeRealm(TimeData data) {
        TimeRealm result = new TimeRealm();
        RealmList<String> subjects = new RealmList<>();
        subjects.addAll(data.getSubjects());

        result.setSchoolClass(data.getSchoolClass());
        result.setSchoolCode(data.getSchoolCode());
        result.setSubjects(subjects);

        return result;
    }
}
