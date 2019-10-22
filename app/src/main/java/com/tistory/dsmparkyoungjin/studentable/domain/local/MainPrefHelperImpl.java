package com.tistory.dsmparkyoungjin.studentable.domain.local;

import android.content.Context;
import android.content.SharedPreferences;

public class MainPrefHelperImpl implements MainPrefHelper {

    public static final String TIME = "TIME";
    public static final String MEAL = "MEAL";

    private static final String PREFERENCE_NAME = "STUDNETABLE";
    private static final String KEY_RECENT_VIEW = "RECENT_VIEW";
    private static final String KEY_SCHOOL_NAME = "SCHOOL_NAME";
    private static final String KEY_GRADE_NUMBER = "GRADE_NUMBER";
    private static final String KEY_CLASS_NUMBER = "CLASS_NUMBER";

    private static final String DEFVALUE_BLANK = "";
    private static final int DEFVALUE_ZERO = 0;

    private SharedPreferences mSharedPref;

    public MainPrefHelperImpl(Context context) {
        mSharedPref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public String getSchoolName() {
        return mSharedPref.getString(KEY_SCHOOL_NAME, DEFVALUE_BLANK);
    }

    @Override
    public int getGradeNo() {
        return mSharedPref.getInt(KEY_GRADE_NUMBER, DEFVALUE_ZERO);
    }

    @Override
    public int getClassNo() {
        return mSharedPref.getInt(KEY_CLASS_NUMBER, DEFVALUE_ZERO);
    }

    @Override
    public String getRecentView() {
        return mSharedPref.getString(KEY_RECENT_VIEW, TIME);
    }

    @Override
    public void setRecentView(String recentView) {
        mSharedPref.edit().putString(KEY_RECENT_VIEW, recentView).apply();
    }
}
