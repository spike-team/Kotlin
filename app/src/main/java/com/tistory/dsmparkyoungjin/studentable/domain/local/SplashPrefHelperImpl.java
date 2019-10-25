package com.tistory.dsmparkyoungjin.studentable.domain.local;

import android.content.Context;
import android.content.SharedPreferences;

public class SplashPrefHelperImpl implements SplashPrefHelper {

    private static final String PREFERENCE_NAME = "STUDENTABLE";
    private static final String KEY_GOOGLE_AUTH = "GOOGLE_AUTH";
    private static final String KEY_DEVICE_CODE = "DEVICE_CODE";

    private static final String DEFVALUE_BLANK = "";

    private SharedPreferences mSharedPref;

    public SplashPrefHelperImpl(Context context) {
        mSharedPref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Boolean isSet() {
        return !(mSharedPref.getString(KEY_GOOGLE_AUTH, DEFVALUE_BLANK).isEmpty());
    }

    @Override
    public void setGoogleAuth(String mGoogleAuth) {
        mSharedPref.edit().putString(KEY_GOOGLE_AUTH, mGoogleAuth).apply();
    }
}
