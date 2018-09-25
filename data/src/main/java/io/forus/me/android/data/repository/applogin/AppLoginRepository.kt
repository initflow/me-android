package io.forus.me.android.data.repository.applogin

import io.forus.me.android.data.repository.applogin.datasource.AppLoginDataSource

class AppLoginRepository(private val appLoginDataSource: AppLoginDataSource) : io.forus.me.android.domain.repository.applogin.AppLoginRepository {

}