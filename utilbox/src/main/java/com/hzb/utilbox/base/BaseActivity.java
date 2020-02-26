package com.hzb.utilbox.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hzb.utilbox.base.mvp.IView;
import com.hzb.utilbox.util.ClickUtils;
import com.hzb.utilbox.util.DensityUtils;


/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/10/24
 *     desc  : base about activity
 * </pre>
 */
public abstract class BaseActivity extends AppCompatActivity
        implements IBaseView, IView {

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onDebouncingClick(v);
        }
    };

    public View mContentView;

    public Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mActivity = this;
        super.onCreate(savedInstanceState);
        initViewBefore(getIntent().getExtras());
        setContentView();
        initView(savedInstanceState, mContentView);
        doBusiness();
    }

    @Override
    public void initViewBefore(@Nullable Bundle bundle) {
        if (isOpenTouTiaoAutoLayout()) {
            DensityUtils.setDefault(this);
        }
    }

    @Override
    public void setContentView() {
        if (bindLayout() <= 0) return;
        mContentView = LayoutInflater.from(this).inflate(bindLayout(), null);
        setContentView(mContentView);
    }


    /**
     * 是否开启今日头条UI适配
     */
    public boolean isOpenTouTiaoAutoLayout(){
        return true;
    }

    /**
     * 对单视图应用防抖点击
     *
     * @param views
     */
    public void applyDebounClickListener(View... views) {
        ClickUtils.applyGlobalDebouncing(views, mClickListener);
    }


    /**
     * 对单视图应用防抖点击并加入点击特效
     */
    public void applyAnimDebounClickListener(View... views) {
        ClickUtils.applyGlobalDebouncing(views, mClickListener);
        ClickUtils.applyPressedViewScale(views);
    }
}

