package com.pabloSanjuan.listadoproductos.data.di.module

import androidx.lifecycle.ViewModel
import com.pabloSanjuan.listadoproductos.data.di.annotation.ViewModelKey
import com.pabloSanjuan.listadoproductos.presentation.MainActivityViewModel
import com.pabloSanjuan.listadoproductos.presentation.details.DetailsViewModel
import com.pabloSanjuan.listadoproductos.presentation.home.HomeViewModel
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

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(homeViewModel: HomeViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(homeViewModel: DetailsViewModel) : ViewModel
}