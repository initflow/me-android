package io.forus.me.android.presentation.view.screens.applogin

import io.forus.me.android.domain.repository.applogin.AppLoginRepository
import io.forus.me.android.presentation.view.base.lr.LRPresenter
import io.forus.me.android.presentation.view.base.lr.LRViewState
import io.forus.me.android.presentation.view.base.lr.PartialChange
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers

class LoginPresenter constructor(
        private val appLoginRepository: AppLoginRepository
) : LRPresenter<LoginModel, LoginModel, LoginView>() {

    override fun initialModelSingle(): Single<LoginModel> = Single.just(LoginModel())

    override fun LoginModel.changeInitialModel(i: LoginModel): LoginModel {
        return LoginModel()
    }

    override fun bindIntents() {

        val observable = Observable.merge(

                loadRefreshPartialChanges(),

                intent { it.share() }
                        .map {
                            LoginPartialChanges.ShareSuccess(Unit)
                        }

        )


        val initialViewState = LRViewState(
                false,
                null,
                false,
                false,
                null,
                false,
                LoginModel())

        subscribeViewState(
                observable.scan(initialViewState, this::stateReducer)
                        .observeOn(AndroidSchedulers.mainThread()),
                LoginView::render)
    }

    override fun stateReducer(vs: LRViewState<LoginModel>, change: PartialChange): LRViewState<LoginModel> {

        if (change !is LoginPartialChanges) return super.stateReducer(vs, change)

        return when (change) {
            is LoginPartialChanges.ShareSuccess -> vs.copy(model = vs.model.copy(profileShared = true))
        }
    }
}