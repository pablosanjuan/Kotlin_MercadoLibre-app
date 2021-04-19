package com.pabloSanjuan.listadoproductos.data.di.module

import com.pabloSanjuan.listadoproductos.presentation.details.DetailsFragment
import com.pabloSanjuan.listadoproductos.presentation.home.HomeFragment
import com.pabloSanjuan.listadoproductos.presentation.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentsBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributesInjectHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributesInjectSplashFragment(): SplashFragment

    @ContributesAndroidInjector
    abstract fun contributesInjectDetailsFragment(): DetailsFragment
}