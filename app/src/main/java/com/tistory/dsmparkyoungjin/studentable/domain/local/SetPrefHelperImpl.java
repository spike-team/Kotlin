package com.tistory.dsmparkyoungjin.studentable.domain.local;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.tistory.dsmparkyoungjin.studentable.data.SchoolData;

public class SetPrefHelperImpl implements SetPrefHelper {

    private static final String PREFERENCE_NAME = "STUDENTABLE";
    private static final String KEY_SET_SCHOOL_NAME = "SET_SCHOOL_NAME";
    private static final String KEY_SET_SCHOOL_CODE = "SET_SCHOOL_CODE";
    private static final String KEY_SET_CLASS_NUMBER = "SET_CLASS_NUMBER";
    private static final String KEY_SET_GRADE_NUMBER = "SET_GRADE_NUMBER";

    private static final String KEY_SCHOOL_SEARCH = "SCHOOL_SEARCH";
    private static final String KEY_SCHOOL_NAME = "SCHOOL_NAME";
    private static final String KEY_SCHOOL_CODE = "SCHOOL_CODE";
    private static final String KEY_GRADE_NUMBER = "GRADE_NUMBER";
    private static final String KEY_CLASS_NUMBER = "CLASS_NUMBER";

    private static final String DEFVALUE_BLANK = "";
    private static final int DEFVALUE_ZERO = 0;

    private SharedPreferences mSharedPref;

    public SetPrefHelperImpl(Context context) {
        mSharedPref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public void setSearch(String search) {
        mSharedPref.edit().putString(KEY_SCHOOL_SEARCH, search).apply();
    }

    @Override
    public String getSearch() {
        return mSharedPref.getString(KEY_SCHOOL_SEARCH, DEFVALUE_BLANK);
    }

    @Override
    public String getSchoolCode() {
        return mSharedPref.getString(KEY_SCHOOL_CODE, DEFVALUE_BLANK);
    }

    @Override
    public String getSchoolName() {
        return mSharedPref.getString(KEY_SET_SCHOOL_NAME, DEFVALUE_BLANK);
    }

    @Override
    public void setSchool(SchoolData mSchoolData) {
        mSharedPref.edit().putString(KEY_SET_SCHOOL_NAME, mSchoolData.getName()).apply();
        mSharedPref.edit().putString(KEY_SET_SCHOOL_CODE, mSchoolData.getCode()).apply();
    }

    @Override
    public void setGradeNo(int gradeNo) {
        mSharedPref.edit().putInt(KEY_SET_GRADE_NUMBER, gradeNo).apply();
    }

    @Override
    public void setClassNo(int classNo) {
        mSharedPref.edit().putInt(KEY_SET_CLASS_NUMBER, classNo).apply();
    }

    @Override
    public void saveAll() {
        @SuppressLint("CommitPrefEdits")
        SharedPreferences.Editor editor = mSharedPref.edit();

        editor.putString(KEY_SCHOOL_NAME, mSharedPref.getString(KEY_SET_SCHOOL_NAME, DEFVALUE_BLANK)).apply();
        editor.putString(KEY_SCHOOL_CODE, mSharedPref.getString(KEY_SET_SCHOOL_CODE, DEFVALUE_BLANK)).apply();
        editor.putInt(KEY_GRADE_NUMBER, mSharedPref.getInt(KEY_SET_GRADE_NUMBER, DEFVALUE_ZERO)).apply();
        editor.putInt(KEY_CLASS_NUMBER, mSharedPref.getInt(KEY_SET_CLASS_NUMBER, DEFVALUE_ZERO)).apply();
    }
}
