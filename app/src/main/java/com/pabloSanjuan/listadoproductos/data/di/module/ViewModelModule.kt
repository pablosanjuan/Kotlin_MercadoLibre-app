package com.pabloSanjuan.listadoproductos.data.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pabloSanjuan.listadoproductos.data.di.annotation.ViewModelKey
import com.pabloSanjuan.listadoproductos.data.di.factory.ViewModelFactory
import com.pabloSanjuan.listadoproductos.presentation.base.MainActivityViewModel
import com.pabloSanjuan.listadoproductos.presentation.config.ConfigViewModel
import com.pabloSanjuan.listadoproductos.presentation.details.DetailsViewModel
import com.pabloSanjuan.listadoproductos.presentation.home.HomeViewModel
import com.pabloSanjuan.listadoproductos.presentation.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Pablo Sanjuan
 *
 * Modulo para definir los ViewModels que seran inyectados a traves del patron Factory
 */

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

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

    @Binds
    @IntoMap
    @ViewModelKey(ConfigViewModel::class)
    abstract fun bindDetailsConfigViewModel(homeViewModel: ConfigViewModel) : ViewModel
}