package com.pabloSanjuan.listadoproductos.presentation.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.Observer
import com.pabloSanjuan.listadoproductos.MainApplication.Companion.appComponent
import com.pabloSanjuan.listadoproductos.databinding.ActivitySplashBinding
import com.pabloSanjuan.listadoproductos.presentation.base.MainActivity
import com.pabloSanjuan.listadoproductos.presentation.base.BaseActivity
import com.pabloSanjuan.listadoproductos.utils.ThemeProvider
import javax.inject.Inject

class SplashActivity : BaseActivity<SplashViewModel, ActivitySplashBinding>() {

    private lateinit var viewModel: SplashViewModel
    @Inject
    lateinit var themeProvider: ThemeProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        appComponent.inject(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
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