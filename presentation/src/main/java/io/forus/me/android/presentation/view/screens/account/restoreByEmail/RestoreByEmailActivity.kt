package io.forus.me.android.presentation.view.screens.account.restoreByEmail


import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.forus.me.android.presentation.R

import io.forus.me.android.presentation.view.activity.BaseActivity
import io.forus.me.android.presentation.view.activity.ToolbarActivity

/**
 * Main application screen. This is the app entry point.
 */
class RestoreByEmailActivity : ToolbarActivity() {


    companion object {
        fun getCallingIntent(context: Context): Intent {
            return Intent(context, RestoreByEmailActivity::class.java)
        }
    }

    override val viewID: Int
        get() = R.layout.activity_toolbar

    override val toolbarTitle: String
        get() = getString(R.string.inloggen_via_email)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, RestoreByEmailFragment())
        }
    }


}
