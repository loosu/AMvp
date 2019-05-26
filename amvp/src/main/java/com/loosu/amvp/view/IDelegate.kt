package com.loosu.kmvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

interface IDelegate {

    var rootView: View?

    fun create(layoutInflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)

    fun init()

    fun <T : View> getViewById(viewId: Int): T

    fun setOnClickListener(listener: View.OnClickListener?, vararg viewIds: Int)
}
