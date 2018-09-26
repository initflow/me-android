package io.forus.me.android.presentation.view.screens.applogin

import android.os.Bundle
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
        override fun retryClicks(): Observable<Any> = Observable.never()

        override fun refreshes(): Observable<Any> = Observable.never()

        override fun render(vs: LRViewState<*>) {

        }
    }

    private lateinit var key: String

    override fun share(): Observable<Unit> = RxView.clicks(btn_share).map { Unit }

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
            Injection.instance.appLoginRepository
    )


    override fun render(vs: LRViewState<LoginModel>) {
        super.render(vs)

        if(vs.model.loginInfo != null){
            tv_organization_name.text = vs.model.loginInfo.organization.title
        }

        if(vs.model.profileShared){
            btn_share.visibility = View.GONE
            tv_request.visibility = View.GONE
            setBackgroundColor(resources.getColor(R.color.green_bg))
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