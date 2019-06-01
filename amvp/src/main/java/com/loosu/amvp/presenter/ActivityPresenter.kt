package com.loosu.kmvp.presenter

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.loosu.kmvp.view.IViewDelegate

/**
 * 解耦层 Activity 基类
 */
abstract class ActivityPresenter<T : IViewDelegate> : AppCompatActivity() {

    protected var mViewDelegate: T? = null

    init {
        try {
            mViewDelegate = getDelegateClass().newInstance()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InstantiationException) {
            e.printStackTrace()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewDelegate!!.create(layoutInflater, null, savedInstanceState)
        setContentView(mViewDelegate!!.rootView)
        mViewDelegate!!.init()
    }

    override fun onDestroy() {
        super.onDestroy()
        mViewDelegate = null
    }

    abstract fun getDelegateClass(): Class<out T>
}
