package com.hzb.codebox.mvp;

import com.hzb.utilbox.base.mvp.IView;
import com.hzb.utilbox.base.mvp.IPresenter;

public interface LoginConstract {

    interface View extends IView {
        void showLogin(String info);
    }

    interface Presenter extends IPresenter<View>{
        void login();
    }
}
