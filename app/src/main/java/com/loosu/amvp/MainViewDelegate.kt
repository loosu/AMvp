package com.loosu.amvp


import com.loosu.kmvp.view.ViewDelegate

class MainViewDelegate : ViewDelegate(), IMainViewDelegate {
    override fun getRootLayoutId(): Int {
        return R.layout.activity_main
    }
}
