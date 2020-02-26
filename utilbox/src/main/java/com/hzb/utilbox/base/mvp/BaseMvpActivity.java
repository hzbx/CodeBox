package com.hzb.utilbox.base.mvp;

import android.os.Bundle;

import com.hzb.utilbox.base.BaseActivity;

/**
 * 支持mvp模式下的基类activity
 * @param <P>
 */
public  abstract class BaseMvpActivity<P extends IPresenter> extends BaseActivity {
    protected P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mPresenter == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        mPresenter.onAttachView(this,savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mPresenter != null) {
            mPresenter.onSaveInstanceState(outState);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDetachView(false);
        }
    }
}
