package com.pabloSanjuan.listadoproductos.data.di.module

import android.app.Application
import android.content.Context
import com.pabloSanjuan.listadoproductos.utils.ThemeProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Pablo Sanjuan
 *
 * Modulo para proveer instacias genericas a la app
 */

@Module
class AppModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun provideThemeProvider(): ThemeProvider = ThemeProvider(application)
}

