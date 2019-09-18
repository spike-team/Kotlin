package com.tistory.dsmparkyoungjin.domain.common;

import io.reactivex.Flowable;

public interface UseCase<T, E> {

    E createSingle(T data);
}
