package com.tistory.dsmparkyoungjin.data.datasource;

import com.tistory.dsmparkyoungjin.data.local.preference.SetPrefHelper;

public class SetDataSourceImpl implements SetDataSource {

    private SetPrefHelper mSetPrefHelper;

    public SetDataSourceImpl(SetPrefHelper setPrefHelper) { mSetPrefHelper = setPrefHelper; }

    @Override
    public Boolean isSet() { return mSetPrefHelper.isSet(); }
}
