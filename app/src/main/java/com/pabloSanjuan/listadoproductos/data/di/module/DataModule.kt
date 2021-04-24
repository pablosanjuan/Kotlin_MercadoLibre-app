package com.pabloSanjuan.listadoproductos.data.di.module

import com.pabloSanjuan.listadoproductos.data.di.repositories.SearchRepositoryImpl
import com.pabloSanjuan.listadoproductos.data.service.ProductsService
import com.pabloSanjuan.listadoproductos.domain.repositories.SearchRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Pablo Sanjuan
 *
 *Modlo para generar instancias del patro repositorio, aqui se adjuntan nuevas instancias
 * de funcionalidades de la app si se quisiera implementar nuevas funcionalidades
 */

@Module
class DataModule {
    @Provides
    @Singleton
    internal fun provideProductRepository(productsService: ProductsService): SearchRepository =
        SearchRepositoryImpl(productsService)
}