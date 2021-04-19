package com.pabloSanjuan.listadoproductos.data.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pabloSanjuan.listadoproductos.data.di.annotation.ViewModelKey
import com.pabloSanjuan.listadoproductos.data.di.factory.ViewModelFactory
import com.pabloSanjuan.listadoproductos.presentation.MainActivityViewModel
import com.pabloSanjuan.listadoproductos.presentation.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainViewModel(mainActivityViewModel: MainActivityViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(splashViewModel: SplashViewModel) : ViewModel
}