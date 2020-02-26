package com.hzb.utilbox.constant;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TipType {
    public static final int TYPE_MSG = 0; //消息
    public static final int TYPE_SUC = 1; //成功
    public static final int TYPE_WARN = 2; //警告
    public static final int TYPE_ERROR = 3; //错误

    @Retention(RetentionPolicy.SOURCE)
    //这里指定int的取值只能是以下范围
    @IntDef({TYPE_MSG, TYPE_SUC, TYPE_WARN, TYPE_ERROR})
    public @interface TipTypeDef {
    }
}
