package io.forus.me.android.presentation.view.screens.applogin

import android.content.Context
import com.afollestad.materialdialogs.MaterialDialog
import io.forus.me.android.presentation.R

class ShareSuccessDialog(private val context: Context,
                         private val positiveCallback: () -> Unit,
                         private val cancelListener: () -> Unit){

    private val dialog: MaterialDialog = MaterialDialog.Builder(context)
            .title(context.resources.getString(R.string.app_login_share_success))
            .icon(context.resources.getDrawable(R.drawable.ic_tick))
            .content(context.resources.getString(R.string.app_login_share_success_description))
            .positiveText(context.resources.getString(R.string.me_ok))
            .onPositive { dialog, which -> positiveCallback.invoke() }
            .cancelListener { cancelListener.invoke() }
            .build()

    fun show(){
        dialog.show()
    }
}