package com.hzb.codebox.mvp;

import com.hzb.utilbox.base.mvp.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginConstract.View> implements LoginConstract.Presenter {

    @Override
    public void login() {
        getView().showLogin("dfdfd");
    }
}
