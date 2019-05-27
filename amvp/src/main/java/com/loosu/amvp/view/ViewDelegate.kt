package com.loosu.kmvp.view


import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * 视图层代理抽象类
 */
abstract class ViewDelegate : IDelegate {

    override var rootView: View? = null

    private val views = SparseArray<View>()

    override fun create(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) {
        rootView = layoutInflater.inflate(getRootLayoutId(), container, false)
    }

    abstract fun getRootLayoutId(): Int

    override fun init() {
        // 子类实现
    }

    override fun <T : View> getViewById(viewId: Int): T {
        var view = views.get(viewId)
        if (view == null) {
            view = rootView!!.findViewById(viewId)
            views.put(viewId, view)
        }
        return view as T
    }

    override fun setEnable(enable: Boolean, vararg viewIds: Int) {
        viewIds.forEach {
            getViewById<View>(it).isEnabled = enable
        }
    }

    override fun setOnClickListener(listener: View.OnClickListener?, vararg viewIds: Int) {
        viewIds.forEach {
            getViewById<View>(it).setOnClickListener(listener)
        }
    }
}
