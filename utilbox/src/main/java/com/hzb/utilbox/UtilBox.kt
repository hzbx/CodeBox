package com.hzb.utilbox

import android.app.Application
import com.hzb.utilbox.util.DensityUtils
import com.hzb.utilbox.util.LogUtils

/**
 * application call init() if user utilbox
 */
object UtilBox {
    /**
     * 初始化
     */
    fun init(app:Application,isDebug:Boolean){
        DensityUtils.setDensity(app)
        LogUtils.setLogPrint(isDebug)
    }
}