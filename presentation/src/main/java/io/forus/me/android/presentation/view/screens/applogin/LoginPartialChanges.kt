package io.forus.me.android.presentation.view.screens.applogin

import io.forus.me.android.presentation.view.base.lr.PartialChange

sealed class LoginPartialChanges : PartialChange {

    data class ShareSuccess(val void: Unit) : LoginPartialChanges()

}