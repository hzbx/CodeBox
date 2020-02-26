package com.hzb.utilbox.constant;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class LoadType {
    public static final int LOAD_NO_NET = 0; //没有网络
    public static final int LOAD_ERROR = 1; //失败
    public static final int LOAD_SUC = 2; //加载完成

    @Retention(RetentionPolicy.SOURCE)
    //这里指定int的取值只能是以下范围
    @IntDef({LOAD_NO_NET, LOAD_ERROR,LOAD_SUC})
    public @interface LoadTypeDef {
    }
}
