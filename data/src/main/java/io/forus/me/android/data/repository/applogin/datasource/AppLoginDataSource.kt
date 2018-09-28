package io.forus.me.android.data.repository.applogin.datasource

import io.forus.me.android.data.entity.applogin.CreateLoginResponse
import io.forus.me.android.data.entity.applogin.LoginInfo
import io.forus.me.android.data.entity.applogin.LoginResponse
import io.reactivex.Observable

interface AppLoginDataSource {

    fun createLogin(token: String): Observable<CreateLoginResponse>

    fun loginInfo(key: String) : Observable<LoginInfo>

    fun loginAllow(key: String, authToken: String, isSubscribe: Boolean) : Observable<LoginResponse>

    fun loginDisallow(key: String) : Observable<LoginResponse>
}