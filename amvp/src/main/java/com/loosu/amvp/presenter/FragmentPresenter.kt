package com.loosu.kmvp.presenter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.loosu.kmvp.view.IDelegate

abstract class FragmentPresenter<T : IDelegate> : Fragment() {

    protected var mViewDelegate: T? = null


    init {
        try {
            mViewDelegate = getDelegateClass().newInstance()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: java.lang.InstantiationException) {
            e.printStackTrace()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mViewDelegate!!.create(layoutInflater, container, savedInstanceState)
        return mViewDelegate!!.rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewDelegate!!.init()
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewDelegate = null
    }

    abstract fun getDelegateClass():Class<T>
}
