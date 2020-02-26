package com.hzb.utilbox.base.mvp;

import android.os.Bundle;

import java.lang.ref.WeakReference;

public class BasePresenter<V extends IView> implements IPresenter<V> {
    private WeakReference<V> viewRef;

    protected V getView() {
        return viewRef.get();
    }

    @Override
    public void onAttachView(V view, Bundle savedInstanceState) {
            viewRef=new WeakReference<V>(view);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

    }

    @Override
    public void onDetachView(boolean retainInstance) {
        if (viewRef != null) {
            viewRef.clear();
            viewRef = null;
        }
    }
}
