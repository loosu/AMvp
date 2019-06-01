package com.loosu.amvp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.loosu.kmvp.presenter.ActivityPresenter

class MainActivity : ActivityPresenter<IMainViewViewDelegate>() {
    override fun getDelegateClass(): Class<out IMainViewViewDelegate> {
        return MainViewViewDelegate::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListener(savedInstanceState)
    }

    private fun initListener(savedInstanceState: Bundle?) {
        mViewDelegate!!.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@MainActivity, "test", Toast.LENGTH_SHORT).show()
        }, R.id.btn_test)
    }
}
