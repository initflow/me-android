package io.forus.me.android.data.repository.applogin.datasource.remote

import io.forus.me.android.data.entity.applogin.*
import io.forus.me.android.data.net.applogin.AppLoginService
import io.forus.me.android.data.repository.applogin.datasource.AppLoginDataSource
import io.forus.me.android.data.repository.datasource.RemoteDataSource
import io.reactivex.Observable

class AppLoginRemoteDataSource(f: () -> AppLoginService): AppLoginDataSource, RemoteDataSource<AppLoginService>(f) {

    override fun createLogin(token: String): Observable<CreateLoginResponse> {
        return service.createLogin(CreateLoginRequest(token))
    }

    override fun loginInfo(key: String): Observable<LoginInfo> {
        return service.loginInfo(key)
    }

    override fun loginAllow(key: String, authToken: String): Observable<LoginResponse> {
        return service.loginAllow(AllowRequest(key, authToken))
    }

    override fun loginDisallow(key: String): Observable<LoginResponse> {
        return service.loginDisallow(DisallowRequest(key))
    }
}