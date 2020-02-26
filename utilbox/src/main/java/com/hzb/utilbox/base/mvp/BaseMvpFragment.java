package com.hzb.utilbox.base.mvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.hzb.utilbox.base.BaseFragment;
/**
 * 支持mvp模式下的基类Fragment
 * @param <P>
 */
public abstract class BaseMvpFragment<P extends IPresenter> extends BaseFragment {
    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        mPresenter.onAttachView(this,savedInstanceState);
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null) {
            mPresenter.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDetachView(false);
        }
    }
}
