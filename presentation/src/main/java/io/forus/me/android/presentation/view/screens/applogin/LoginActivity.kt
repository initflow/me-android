package io.forus.me.android.presentation.view.screens.applogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import io.forus.me.android.presentation.R
import io.forus.me.android.presentation.view.activity.CommonActivity

class LoginActivity : CommonActivity() {

    companion object {

        val LOGIN_KEY_EXTRA = "LOGIN_KEY_EXTRA"

        fun getCallingIntent(context: Context, id: String): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            intent.putExtra(LOGIN_KEY_EXTRA, id)
            return intent
        }
    }


    override val viewID: Int
        get() = R.layout.activity_toolbar



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            val fragment = LoginFragment.newIntent(intent.getStringExtra(LOGIN_KEY_EXTRA))

            addFragment(R.id.fragmentContainer, fragment)
        }
    }
}