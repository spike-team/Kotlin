package com.tistory.dsmparkyoungjin.data.local.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class SetPrefHelperImpl implements SetPrefHelper {

    private SharedPreferences mSetPref;

    private String PREFERENCE_NAME = "SET_PREFERENCE";

    private String PREF_ISSET = "PREF_ISSET";

    public SetPrefHelperImpl(Context context) {
        mSetPref = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

    @Override
    public Boolean isSet() { return mSetPref.getBoolean(PREF_ISSET, false); }
}
