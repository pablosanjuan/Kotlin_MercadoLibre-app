package com.pabloSanjuan.listadoproductos

import android.app.Application
import com.pabloSanjuan.listadoproductos.data.di.component.AppComponent
import com.pabloSanjuan.listadoproductos.data.di.component.DaggerAppComponent

open class MainApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
            private set
    }

    protected fun prepareAppComponent(): AppComponent {
        return DaggerAppComponent.builder().build()
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = prepareAppComponent()
    }
}