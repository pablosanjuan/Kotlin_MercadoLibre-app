package com.pabloSanjuan.listadoproductos.data.di.component

import android.app.Application
import com.pabloSanjuan.listadoproductos.MainApplication
import com.pabloSanjuan.listadoproductos.data.di.module.*
import com.pabloSanjuan.listadoproductos.presentation.MainActivity
import com.pabloSanjuan.listadoproductos.presentation.base.BaseActivity
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment
import com.pabloSanjuan.listadoproductos.presentation.splash.SplashFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        AppModule::class,
        NetModule::class,
        DataModule::class,
        DomainModule::class,
        ViewModelFactoryModule::class]
)
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    // Classes we can inject to by this Component
//    fun inject(activity: BaseActivity<Any>)
//    fun inject(baseFragment: BaseFragment<Any>)
//    fun inject(mainActivity: MainActivity)
//    fun inject(splashFragment: SplashFragment)
}