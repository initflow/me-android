package com.ocrv.ekasui.mrm.ui.loadRefresh

import android.support.annotation.CallSuper
import android.support.design.widget.Snackbar
import android.view.View
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import com.hannesdorfmann.mosby3.mvi.MviFragment
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import io.forus.me.android.presentation.R
import io.forus.me.android.presentation.helpers.OnCompleteListener
import io.forus.me.android.presentation.internal.Injection
import io.forus.me.android.presentation.navigation.Navigator


abstract class LRFragment<M, V : LRView<M>, P : MviBasePresenter<V, LRViewState<M>>> : MviFragment<V, P>(), LRView<M> {

    protected val navigator = Navigator()

    protected abstract fun viewForSnackbar(): View
    protected abstract fun loadRefreshPanel(): LoadRefreshPanel

    override fun retry(): Observable<Any> = loadRefreshPanel().retryClicks()
    override fun refresh(): Observable<Any> = loadRefreshPanel().refreshes()

    override fun updateData(): Observable<Any> {
        return updateObservable;
    }

    protected fun showToastMessage(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    public fun updateModel(){
        if(updateObservable != null){
            updateObservable.onNext(true)
        }
    }




    override fun onResume() {
        super.onResume()
        mOnCompleteListener?.onResume()
    }

    open fun getScrollableView(): View? {
        return null;
    }

    private val updateObservable = PublishSubject.create<Any>();



    @CallSuper
    override fun render(vs: LRViewState<M>) {
        loadRefreshPanel().render(vs)
        if (vs.refreshingError != null) {
            Snackbar.make(viewForSnackbar(), R.string.refreshing_error_text, Snackbar.LENGTH_SHORT).show()
        }
    }


    var mOnCompleteListener: OnCompleteListener? = null








}