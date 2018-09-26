package io.forus.me.android.domain.repository.applogin

import io.forus.me.android.domain.models.applogin.LoginInfo
import io.reactivex.Observable

interface AppLoginRepository {

    fun createLogin(publicKey: String): Observable<String>

    fun loginInfo(key: String) : Observable<LoginInfo>

    fun loginAllow(key: String, authToken: String) : Observable<Boolean>

    fun loginDisallow(key: String) : Observable<Boolean>
}