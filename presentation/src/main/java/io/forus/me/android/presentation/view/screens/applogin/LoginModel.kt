package io.forus.me.android.presentation.view.screens.applogin

import io.forus.me.android.domain.models.applogin.LoginInfo

data class LoginModel(
        val loginInfo: LoginInfo? = null,
        val profileShared: Boolean = false
)