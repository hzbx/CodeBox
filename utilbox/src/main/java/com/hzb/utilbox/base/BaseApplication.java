package com.hzb.utilbox.base;

import android.app.Application;
import android.content.Context;


import androidx.multidex.MultiDex;

import com.hzb.utilbox.UtilBox;
import com.hzb.utilbox.util.CrashUtils;
import com.hzb.utilbox.util.LogUtils;


/**
 *  闪退处理以及MultiDex处理
 *  如果使用qmui的ui框架 在Theme中需要切换为Qmui内置主题
 */
public abstract  class BaseApplication extends Application {

    private static BaseApplication sInstance;

    public static BaseApplication getInstance() {
        return sInstance;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        UtilBox.INSTANCE.init(this,getPrintLogStatus());
        initCrash();
    }



    private void initCrash() {
        CrashUtils.init(new CrashUtils.OnCrashListener() {
            @Override
            public void onCrash(String crashInfo, Throwable e) {
                LogUtils.e("CRASH",crashInfo);
            }
        });
    }

    /**
     * log打印开关
     * @return
     */
    protected abstract boolean getPrintLogStatus();
}
