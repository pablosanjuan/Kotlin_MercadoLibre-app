package com.pabloSanjuan.listadoproductos.data.di.module

import com.pabloSanjuan.listadoproductos.domain.repositories.SearchRepository
import com.pabloSanjuan.listadoproductos.domain.usescases.GetSearchUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DomainModule {

    @Provides
    @Singleton
    fun provideGetProductUseCase(searchRepository: SearchRepository): GetSearchUseCase =
        GetSearchUseCase(searchRepository)
}