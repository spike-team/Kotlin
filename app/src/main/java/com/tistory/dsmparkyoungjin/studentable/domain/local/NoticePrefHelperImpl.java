package com.tistory.dsmparkyoungjin.studentable.domain.local;

import android.content.Context;
import android.content.SharedPreferences;

public class NoticePrefHelperImpl implements NoticePrefHelper {

    private static final String PREFERENCE_NAME = "STUDNETABLE";
    private static final String KEY_FCM = "FCM";

    private static final Boolean DEFVALUE_FALSE = false;

    private SharedPreferences mSharedPref;

    public NoticePrefHelperImpl(Context context) {
        mSharedPref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Boolean isEnable() {
        return mSharedPref.getBoolean(KEY_FCM, DEFVALUE_FALSE);
    }

    @Override
    public void setEnable() {
        mSharedPref.edit().putBoolean(KEY_FCM, true).apply();
    }

    @Override
    public void setDisable() {
        mSharedPref.edit().putBoolean(KEY_FCM, false).apply();
    }
}
