package com.loosu.amvp


import com.loosu.kmvp.view.ViewViewDelegate

class MainViewViewDelegate : ViewViewDelegate(), IMainViewViewDelegate {
    override fun getRootLayoutId(): Int {
        return R.layout.activity_main
    }
}
