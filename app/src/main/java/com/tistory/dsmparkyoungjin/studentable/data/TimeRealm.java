package com.tistory.dsmparkyoungjin.studentable.data;

import io.realm.RealmList;
import io.realm.RealmObject;

public class TimeRealm extends RealmObject {

    private String schoolCode;

    private String schoolClass;

    private RealmList<String> subjects;

    public TimeRealm() {
    }

    public TimeRealm(String schoolCode, String schoolClass, RealmList<String> subjects) {
        this.schoolCode = schoolCode;
        this.schoolClass = schoolClass;
        this.subjects = subjects;
    }

    void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    void setSchoolClass(String schoolClass) {
        this.schoolClass = schoolClass;
    }

    public RealmList<String> getSubjects() {
        return subjects;
    }

    void setSubjects(RealmList<String> subjects) {
        this.subjects = subjects;
    }
}
