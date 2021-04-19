package com.pabloSanjuan.listadoproductos.presentation

import android.os.Bundle
import androidx.lifecycle.Observer
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.presentation.base.BaseActivity

class MainActivity : BaseActivity<MainActivityViewModel>() {

    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = initViewModel()
        viewModel.getData()

        viewModel.productsList.observe(this, Observer {
            val ss = it
        })

    }
}