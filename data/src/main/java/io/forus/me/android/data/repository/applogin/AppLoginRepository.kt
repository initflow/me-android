package io.forus.me.android.data.repository.applogin

import io.forus.me.android.data.repository.applogin.datasource.AppLoginDataSource
import io.forus.me.android.domain.models.applogin.LoginInfo
import io.reactivex.Observable

class AppLoginRepository(private val appLoginDataSource: AppLoginDataSource) : io.forus.me.android.domain.repository.applogin.AppLoginRepository {

    override fun createLogin(publicKey: String): Observable<String> {
        return appLoginDataSource.createLogin(publicKey).map { it.token }
    }

    override fun loginInfo(key: String): Observable<LoginInfo> {
        return appLoginDataSource.loginInfo(key).map { LoginInfo(it.key, it.status, it.authToken,
                it.data, io.forus.me.android.domain.models.applogin.LoginInfo.Organization(it.organization.title, it.organization.owner, it.organization.publicKey)) }
    }

    override fun loginAllow(key: String, authToken: String): Observable<Boolean> {
        return appLoginDataSource.loginAllow(key, authToken).map { true }
    }

    override fun loginDisallow(key: String): Observable<Boolean> {
        return appLoginDataSource.loginDisallow(key).map { true }
    }
}