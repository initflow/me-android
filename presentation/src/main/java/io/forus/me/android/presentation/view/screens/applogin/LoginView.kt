package io.forus.me.android.presentation.view.screens.applogin

import io.forus.me.android.presentation.view.base.lr.LRView
import io.reactivex.Observable

interface LoginView : LRView<LoginModel> {

    fun share(): Observable<Unit>

    fun decline(): Observable<Unit>

    fun switchSubscribe(): Observable<Unit>
}