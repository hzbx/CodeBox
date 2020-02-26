package com.hzb.utilbox.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.hzb.utilbox.base.mvp.IView;
import com.hzb.utilbox.util.ClickUtils;


public abstract class BaseFragment extends Fragment
        implements IBaseView, IView {

    private static final String STATE_SAVE_IS_HIDDEN = "STATE_SAVE_IS_HIDDEN";

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onDebouncingClick(v);
        }
    };

    protected AppCompatActivity mActivity;
    protected LayoutInflater    mInflater;
    protected View              mContentView;

    protected boolean mIsVisibleToUser;
    protected boolean mIsBusinessDone;
    protected boolean mIsInPager;

    /**
     * @return true true {@link #doBusiness()} will lazy in view pager, false otherwise
     */
    public boolean isLazy() {
        return false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mIsInPager = true;
        if (isVisibleToUser) mIsVisibleToUser = true;
        if (isLazy()) {
            if (!mIsBusinessDone && isVisibleToUser && mContentView != null) {
                mIsBusinessDone = true;
                doBusiness();
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = getFragmentManager();
        if (fm == null) return;
        if (savedInstanceState != null) {
            boolean isSupportHidden = savedInstanceState.getBoolean(STATE_SAVE_IS_HIDDEN);
            FragmentTransaction ft = fm.beginTransaction();
            if (isSupportHidden) {
                ft.hide(this);
            } else {
                ft.show(this);
            }
            ft.commitAllowingStateLoss();
        }
        Bundle bundle = getArguments();
        initViewBefore(bundle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mInflater = inflater;
        setContentView();
        return mContentView;
    }

    @Override
    public void setContentView() {
        if (bindLayout() <= 0) return;
        mContentView = mInflater.inflate(bindLayout(), null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(savedInstanceState, mContentView);
        if (!mIsInPager || !isLazy() || mIsVisibleToUser) {
            mIsBusinessDone = true;
            doBusiness();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mIsVisibleToUser = false;
        mIsBusinessDone = false;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(STATE_SAVE_IS_HIDDEN, isHidden());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    /**
     * 对单视图应用防抖点击
     * @param views
     */
    public void applyDebounClickListener(View... views) {
        ClickUtils.applyGlobalDebouncing(views, mClickListener);
    }

    /**
     * 对单视图应用防抖点击并加入点击特效
     */
    public void applyAnimDebounClickListener(View... views){
        ClickUtils.applyGlobalDebouncing(views,mClickListener);
        ClickUtils.applyPressedViewScale(views);
    }


    public <T extends View> T findViewById(@IdRes int id) {
        if (mContentView == null) throw new NullPointerException("ContentView is null.");
        return mContentView.findViewById(id);
    }

}
