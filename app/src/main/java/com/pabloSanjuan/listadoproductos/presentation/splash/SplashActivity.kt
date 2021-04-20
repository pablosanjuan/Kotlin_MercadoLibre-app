package com.pabloSanjuan.listadoproductos.presentation.splash

import android.os.Bundle
import androidx.lifecycle.Observer
import com.pabloSanjuan.listadoproductos.databinding.ActivitySplashBinding
import com.pabloSanjuan.listadoproductos.presentation.base.MainActivity
import com.pabloSanjuan.listadoproductos.presentation.base.BaseActivity

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {

    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = initViewModel()
        viewModel.delay()
        initObservers()
    }

    private fun initObservers() {
        viewModel.productsList.observe(this, Observer {
            MainActivity.start(this, null)
            finish()
        })
    }
}