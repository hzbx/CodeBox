package com.hzb.utilbox.util;

import android.util.Log;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/09/21
 *     desc  : utils about log
 * </pre>
 */
public final class LogUtils {

    public static final String TAG = AppUtils.getAppPackageName();

    public static boolean printLog = true;

    public static boolean setLogPrint(Boolean isPrint) {
        return printLog = isPrint;
    }

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void d(String msg) {
        d(TAG, msg);
    }

    public static void v(String msg) {
        v(TAG, msg);
    }

    public static void w(String msg) {
        w(TAG, msg);
    }

    public static void i(String module, String msg) {
        if (printLog) {
            Log.i(TAG, "[" + module + "]" + msg);
        }
    }

    public static void e(String module, String msg) {
        if (printLog) {
            Log.e(TAG, "[" + module + "]" + msg);
        }
    }

    public static void d(String module, String msg) {
        if (printLog) {
            Log.d(TAG, "[" + module + "]" + msg);
        }
    }

    public static void v(String module, String msg) {
        if (printLog) {
            Log.v(TAG, "[" + module + "]" + msg);
        }

    }

    public static void w(String module, String msg) {
        if (printLog) {
            Log.w(TAG, "[" + module + "]" + msg);
        }
    }

}
