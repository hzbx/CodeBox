package com.hzb.codebox


import android.os.Bundle
import android.view.View
import com.hzb.codebox.mvp.LoginConstract
import com.hzb.codebox.mvp.LoginPresenter
import com.hzb.utilbox.base.BaseFragment
import com.hzb.utilbox.base.mvp.BaseMvpFragment
import com.hzb.utilbox.util.ToastUtils
import kotlinx.android.synthetic.main.fragment_blank.*


class BlankFragment : BaseMvpFragment<LoginConstract.Presenter>(),LoginConstract.View {

    override fun initViewBefore(bundle: Bundle?) {

    }

    override fun bindLayout(): Int =R.layout.fragment_blank

    override fun initView(savedInstanceState: Bundle?, contentView: View?) {
        button2.setOnClickListener {
            mPresenter?.login()
        }
    }

    override fun doBusiness() {
    }

    override fun onDebouncingClick(view: View) {

    }

    override fun createPresenter(): LoginConstract.Presenter =LoginPresenter()

    override fun showLogin(info: String?) {
        ToastUtils.showShort(info)
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
