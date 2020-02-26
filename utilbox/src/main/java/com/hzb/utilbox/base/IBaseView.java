package com.hzb.utilbox.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/11/16
 *     desc  :
 * </pre>
 */
public interface IBaseView {

    /**
     * <布局加载前>数据处理
     * @param bundle
     */
    void initViewBefore(@Nullable Bundle bundle);

    /**
     * 绑定布局
     * @return 布局id
     */
    int bindLayout();

    /**
     * activity加载内容布局
     */
    void setContentView();

    /**
     * view 初始化
     * @param savedInstanceState
     * @param contentView
     */
    void initView(@Nullable Bundle savedInstanceState, @Nullable View contentView);

    /**
     * 业务逻辑处理
     */
    void doBusiness();


    /**
     * 实现按钮点击特效:反弹
     * 需要调用applyDebouncingClickListener()方法
     * @param view
     */
    void onDebouncingClick(@NonNull View view);
}
