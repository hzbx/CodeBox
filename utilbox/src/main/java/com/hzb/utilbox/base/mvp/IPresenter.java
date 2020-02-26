package com.hzb.utilbox.base.mvp;

import android.os.Bundle;

public interface IPresenter<V extends IView> {
    void onAttachView(V view, Bundle savedInstanceState);

    void onSaveInstanceState(Bundle savedInstanceState);

    void onDetachView(boolean retainInstance);
}
