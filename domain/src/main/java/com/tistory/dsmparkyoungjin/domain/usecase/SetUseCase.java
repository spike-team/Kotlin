package com.tistory.dsmparkyoungjin.domain.usecase;

import com.tistory.dsmparkyoungjin.domain.common.UseCase;
import com.tistory.dsmparkyoungjin.domain.service.SetService;

public class SetUseCase implements UseCase<String, Boolean> {

    private SetService mSetService;

    public SetUseCase(SetService setService) { mSetService = setService; }

    @Override
    public Boolean createSingle(String data) { return mSetService.isSet(); }

    public Boolean isSet() { return createSingle("Not Used"); }
}
