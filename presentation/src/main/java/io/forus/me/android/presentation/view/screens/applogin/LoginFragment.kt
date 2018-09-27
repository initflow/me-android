package io.forus.me.android.presentation.view.screens.applogin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.RxView
import io.forus.me.android.presentation.R
import io.forus.me.android.presentation.internal.Injection
import io.forus.me.android.presentation.view.base.lr.LRViewState
import io.forus.me.android.presentation.view.base.lr.LoadRefreshPanel
import io.forus.me.android.presentation.view.fragment.ToolbarLRFragment
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_app_login.*

class LoginFragment : ToolbarLRFragment<LoginModel, LoginView, LoginPresenter>(), LoginView{

    companion object {
        private val LOGIN_KEY_EXTRA = "LOGIN_KEY_EXTRA"

        fun newIntent(key: String): LoginFragment = LoginFragment().also {
            val bundle = Bundle()
            bundle.putSerializable(LOGIN_KEY_EXTRA, key)
            it.arguments = bundle
        }
    }

    override val toolbarTitle: String
        get() = getString(R.string.app_login_title)

    override val allowBack: Boolean
        get() = true

    override fun viewForSnackbar(): View = root

    override fun loadRefreshPanel() = object : LoadRefreshPanel {

        init { lr_panel.disableSwipeRefresh() }

        override fun retryClicks(): Observable<Any> = lr_panel.retryClicks()

        override fun refreshes(): Observable<Any> = Observable.never()

        override fun render(vs: LRViewState<*>) =lr_panel.render(vs)
    }

    private lateinit var key: String

    override fun share(): Observable<Unit> = RxView.clicks(btn_share).map { Unit }

    override fun decline(): Observable<Unit> = RxView.clicks(btn_decline).map { Unit }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.fragment_app_login, container, false).also {

        val bundle = this.arguments
        if (bundle != null) {
            key = bundle.getString(LOGIN_KEY_EXTRA)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun createPresenter() = LoginPresenter(
            key,
            Injection.instance.appLoginRepository,
            Injection.instance.accountLocalDataSource
    )


    override fun render(vs: LRViewState<LoginModel>) {
        super.render(vs)

        btn_share.visibility = if(vs.model.profileShared || vs.loading || vs.loadingError != null) View.GONE else View.VISIBLE
        btn_decline.visibility = if(vs.model.profileShared || vs.loading || vs.loadingError != null) View.GONE else View.VISIBLE

        if(vs.model.profileShared){
            setBackgroundColor(resources.getColor(R.color.green_bg))
        }

        if(vs.loadingError != null){
            Snackbar.make(viewForSnackbar(), R.string.app_login_info_error, Snackbar.LENGTH_SHORT).show()
        }

        if(vs.closeScreen) closeScreen()
    }

    private fun setBackgroundColor(color: Int){
        root.setBackgroundColor(color)
        setToolbarBackgroundColor(color)
    }

    private fun closeScreen() {
        activity?.finish()
    }
}