package io.forus.me.android.presentation.view.screens.applogin

import io.forus.me.android.data.repository.account.datasource.local.AccountLocalDataSource
import io.forus.me.android.domain.models.applogin.LoginInfo
import io.forus.me.android.domain.repository.applogin.AppLoginRepository
import io.forus.me.android.presentation.view.base.lr.LRPartialChange
import io.forus.me.android.presentation.view.base.lr.LRPresenter
import io.forus.me.android.presentation.view.base.lr.LRViewState
import io.forus.me.android.presentation.view.base.lr.PartialChange
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginPresenter constructor(
        private val key: String,
        private val appLoginRepository: AppLoginRepository,
        private val accountLocalDataSource: AccountLocalDataSource
) : LRPresenter<LoginInfo, LoginModel, LoginView>() {

    var isSubscribe: Boolean = false

    override fun initialModelSingle(): Single<LoginInfo> = Single.fromObservable(appLoginRepository.loginInfo(key))

    override fun LoginModel.changeInitialModel(i: LoginInfo): LoginModel {
        return LoginModel(loginInfo=i)
    }

    override fun bindIntents() {

        val observable = Observable.merge(

                loadRefreshPartialChanges(),

                intent { it.share() }
                        .switchMap {
                            appLoginRepository.loginAllow(key, accountLocalDataSource.getCurrentToken(), isSubscribe)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .map<PartialChange> {
                                        LoginPartialChanges.ShareSuccess(Unit)
                                    }
                                    .onErrorReturn {
                                        LRPartialChange.LoadingError(it)
                                    }
                                    .startWith(LRPartialChange.LoadingStarted)
                        },

                intent { it.decline() }
                        .switchMap {
                            appLoginRepository.loginDisallow(key)
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .map<PartialChange> {
                                        LoginPartialChanges.DeclineSuccess(Unit)
                                    }
                                    .onErrorReturn {
                                        LRPartialChange.LoadingError(it)
                                    }
                                    .startWith(LRPartialChange.LoadingStarted)
                        },

                intent { it.switchSubscribe() }
                        .map { LoginPartialChanges.SwitchSubscribe(Unit) }

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
            is LoginPartialChanges.ShareSuccess -> vs.copy(model = vs.model.copy(profileShared = true), loading = false)
            is LoginPartialChanges.DeclineSuccess -> vs.copy(closeScreen = true)
            is LoginPartialChanges.SwitchSubscribe -> {
                isSubscribe = !vs.model.isSubscribe
                vs.copy(model = vs.model.copy(isSubscribe = isSubscribe))
            }
        }
    }
}