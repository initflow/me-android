package io.forus.me.android.presentation.view.screens.wallets

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ocrv.ekasui.mrm.ui.loadRefresh.LRFragment
import com.ocrv.ekasui.mrm.ui.loadRefresh.LRViewState
import com.ocrv.ekasui.mrm.ui.loadRefresh.LoadRefreshPanel

import io.forus.me.android.presentation.R
import io.forus.me.android.presentation.interfaces.FragmentListener
import io.forus.me.android.presentation.internal.Injection
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_recycler.*

/**
 * Fragment Assign Delegates Screen.
 */
class WalletsFragment : LRFragment<WalletsModel, WalletsView, WalletsPresenter>(), WalletsView, FragmentListener {

    companion object {
        fun newIntent(): WalletsFragment {
            return WalletsFragment()
        }
    }

    private lateinit var adapter: WalletsAdapter

    override fun getTitle(): String = getString(R.string.valuta)

    override fun viewForSnackbar(): View = root

    override fun loadRefreshPanel() = object : LoadRefreshPanel {
        override fun retryClicks(): Observable<Any> = Observable.never()

        override fun refreshes(): Observable<Any> = Observable.never()

        override fun render(vs: LRViewState<*>) {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
            = inflater.inflate(R.layout.fragment_recycler, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = WalletsAdapter()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter

    }


    override fun createPresenter() = WalletsPresenter(
            Injection.instance.walletsRepository
    )


    override fun render(vs: LRViewState<WalletsModel>) {
        super.render(vs)


        adapter.wallets = vs.model.items




    }


}

