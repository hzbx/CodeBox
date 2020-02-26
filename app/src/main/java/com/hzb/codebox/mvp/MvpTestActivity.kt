package com.hzb.codebox.mvp

import android.os.Bundle
import android.view.View
import com.hzb.codebox.R
import com.hzb.utilbox.base.mvp.BaseMvpActivity
import com.hzb.utilbox.constant.TipType
import com.hzb.utilbox.util.ToastUtils
import kotlinx.android.synthetic.main.activity_mvp_test.*

class MvpTestActivity : BaseMvpActivity<LoginConstract.Presenter>(),LoginConstract.View {


    override fun bindLayout(): Int =R.layout.activity_mvp_test

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {
        applyAnimDebounClickListener(button)
    }

    override fun doBusiness() {
    }

    override fun onDebouncingClick(view: View) {
        mPresenter?.login()
    }

    override fun createPresenter(): LoginConstract.Presenter =LoginPresenter()

    override fun showLogin(info: String?) {
        showTip("辅导费",TipType.TYPE_SUC)
    }


    /**
     * 显示提示
     * @param str
     * @param tipType
     */
    override fun showTip(str: String?, tipType: Int) {

    }

    /**
     * 加载中...
     * @param content 提示字段
     */
    override fun loading(content: String?) {
    }

    /**
     * 加载完成
     */
    override fun loadComplete(content: String?, loadType: Int) {

    }
}
