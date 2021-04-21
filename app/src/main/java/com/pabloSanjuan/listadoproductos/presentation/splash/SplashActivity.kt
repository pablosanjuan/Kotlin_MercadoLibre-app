package com.pabloSanjuan.listadoproductos.presentation.splash

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
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
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        ///val theme = themeProvider.getThemeFromPreferences()
        ///AppCompatDelegate.setDefaultNightMode(theme)
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