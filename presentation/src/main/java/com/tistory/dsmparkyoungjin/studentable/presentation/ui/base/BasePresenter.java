package com.tistory.dsmparkyoungjin.studentable.presentation.ui.base;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<T extends BaseContract.View> implements BaseContract.Presenter<T>{

    public BasePresenter(CompositeDisposable composite) { mComposite = composite; }

    public void add(Disposable disposable) { mComposite.add(disposable); }

    @Override
    public void createView(T mView) {
        mWeakReference = new WeakReference<>(mView);
        mView.setPresenter(this);
    }

    @Override
    public void destroyView() {
        mWeakReference.clear();
        mComposite.clear();
    }

    private CompositeDisposable mComposite;

    private WeakReference<T> mWeakReference;

    private T mView = mWeakReference.get();
}
