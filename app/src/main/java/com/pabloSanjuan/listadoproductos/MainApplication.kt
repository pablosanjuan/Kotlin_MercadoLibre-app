package com.pabloSanjuan.listadoproductos

import android.app.Application
import com.pabloSanjuan.listadoproductos.data.di.component.AppComponent
import com.pabloSanjuan.listadoproductos.data.di.component.DaggerAppComponent
import com.pabloSanjuan.listadoproductos.data.di.module.AppModule


/**
 * Pablo Sanjuan
 *
 * Haciendo uso de DAGGER2 creo la clase baseApplication para inicializar todas ls instancias a ser inyectadas
 */

open class MainApplication : Application() {
    companion object {
        lateinit var appComponent: AppComponent
            private set
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = this.initDagger()
    }

    private fun initDagger() = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()
}