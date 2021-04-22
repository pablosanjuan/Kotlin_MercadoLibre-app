package com.pabloSanjuan.listadoproductos.data.di.component

import com.pabloSanjuan.listadoproductos.data.di.module.*
import com.pabloSanjuan.listadoproductos.presentation.base.BaseActivity
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment
import com.pabloSanjuan.listadoproductos.presentation.base.MainActivity
import com.pabloSanjuan.listadoproductos.presentation.config.ConfigFragment
import com.pabloSanjuan.listadoproductos.presentation.details.DetailsFragment
import com.pabloSanjuan.listadoproductos.presentation.home.HomeFragment
import com.pabloSanjuan.listadoproductos.presentation.splash.SplashActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class]
)

interface AppComponent {
    fun inject(baseActivity: BaseActivity<Any, Any>)
    fun inject(baseFragment: BaseFragment<Any, Any>)

    fun inject(mainActivity: MainActivity)
    fun inject(splashActivity: SplashActivity)

    fun inject(homeFragment: HomeFragment)
    fun inject(detailsFragment: DetailsFragment)
    fun inject(configFragment: ConfigFragment)

}