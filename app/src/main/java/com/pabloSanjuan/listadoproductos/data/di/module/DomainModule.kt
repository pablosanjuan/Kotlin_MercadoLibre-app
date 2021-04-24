package com.pabloSanjuan.listadoproductos.data.di.module

import com.pabloSanjuan.listadoproductos.domain.repositories.SearchRepository
import com.pabloSanjuan.listadoproductos.domain.usescases.SearchUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Pablo Sanjuan
 *
 * Modulo para crear instancias de los casos de uso que se adoptan dentro de
 * Clean Architecture
 */

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideSearchUseCase(searchRepository: SearchRepository): SearchUseCase =
        SearchUseCase(searchRepository)
}