package com.hzb.codebox;


import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.*;

import com.hzb.utilbox.base.BaseActivity;
import com.hzb.utilbox.util.LogUtils;

public class TestActivity extends BaseActivity {
    String data="没有数据";
    /**
     * 绑定布局
     * @return 布局id
     */
    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initViewBefore(@Nullable Bundle bundle) {
        super.initViewBefore(bundle);

    }

    @Override
    public void initView(@Nullable Bundle savedInstanceState, @Nullable View contentView) {
        final View top = findViewById(R.id.textView);
        applyAnimDebounClickListener(top);
    }

    @Override
    public void doBusiness() {
        LogUtils.e("doBusiness()-test",getIntent().getStringExtra("title"));
        data="竖屏模式数据";
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtils.e("onConfigurationChanged()->test",getIntent().getStringExtra("title")+"-----"+data);
    }

    @Override
    public void onDebouncingClick(@NonNull View view) {
        int i = 1 / 0;
    }

    /**
     * 显示提示
     *
     * @param str
     * @param tipType
     */
    @Override
    public void showTip(String str, int tipType) {

    }

    /**
     * 加载中...
     *
     * @param content 提示字段
     */
    @Override
    public void loading(String content) {

    }

    /**
     * 加载完成
     *
     * @param content
     * @param loadType
     */
    @Override
    public void loadComplete(String content, int loadType) {

    }


    /****生命周期***/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.e("生命周期->onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e("生命周期->onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e("生命周期->onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e("生命周期->onResume()->"+data);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.e("生命周期->onPause()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.e("生命周期->onDestroy()");
    }
}
