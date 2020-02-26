package com.hzb.utilbox.base.mvp;

import com.hzb.utilbox.constant.LoadType;
import com.hzb.utilbox.constant.TipType;

public interface IView {
    /**
     * 显示提示
     * @param str
     * @param tipType 提示类型
     */
    void showTip(String str, @TipType.TipTypeDef int tipType);

    /**
     * 加载中...
     * @param content 提示字段
     */
    void loading(String content);

    /**
     * 加载完成
     * @param content  提示内容
     * @param loadType 加载状态类型
     */
    void loadComplete(String content, @LoadType.LoadTypeDef int loadType);
}
