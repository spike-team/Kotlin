package com.tistory.dsmparkyoungjin.data.repository;

import com.tistory.dsmparkyoungjin.data.datasource.SetDataSource;
import com.tistory.dsmparkyoungjin.domain.repository.SetRepository;

public class SetRepositoryImpl implements SetRepository {

    private SetDataSource mSetDataSource;

    public SetRepositoryImpl(SetDataSource setDataSource) { mSetDataSource = setDataSource; }

    @Override
    public Boolean isSet() { return mSetDataSource.isSet(); }
}
