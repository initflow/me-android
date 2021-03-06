package io.forus.me.android.presentation.view.screens.account.assigndelegates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.forus.me.android.presentation.R
import io.forus.me.android.presentation.view.fragment.BaseFragment
import kotlinx.android.synthetic.main.account_assign_delegates_qr_fragment.*


class QrFragment : BaseFragment() {

    public var qrText : String = ""
    set(value) {
        field = value

        if (qrImage != null) {
            qrImage.setQRText(value)
        }
    }


    companion object {
        fun newIntent(): QrFragment {
            return QrFragment()
        }
    }
    override fun getLayoutID(): Int {
        return R.layout.account_assign_delegates_qr_fragment
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)

    }





    override fun initUI() {

    }
}

