package io.forus.me.android.data.repository.applogin.datasource.remote

import io.forus.me.android.data.net.applogin.AppLoginService
import io.forus.me.android.data.repository.applogin.datasource.AppLoginDataSource
import io.forus.me.android.data.repository.datasource.RemoteDataSource

class AppLoginRemoteDataSource(f: () -> AppLoginService): AppLoginDataSource, RemoteDataSource<AppLoginService>(f) {

}