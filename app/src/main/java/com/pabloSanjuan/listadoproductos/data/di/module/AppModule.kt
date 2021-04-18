package com.pabloSanjuan.listadoproductos.data.di.module

import android.app.Application
import android.content.Context
import com.pabloSanjuan.listadoproductos.data.di.repositories.ProductRepositoryImpl
import com.pabloSanjuan.listadoproductos.data.service.ProductsService
import com.pabloSanjuan.listadoproductos.domain.repositories.ProductRepository
import com.pabloSanjuan.listadoproductos.domain.usescases.GetProductUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: Application): Context {
        return app.applicationContext
    }

    @Provides
    @Singleton
    internal fun provideProductRepository(productsService: ProductsService): ProductRepository =
        ProductRepositoryImpl(productsService)



    @Provides
    @Singleton
    fun provideGetProductUseCase(productRepository: ProductRepository): GetProductUseCase =
        GetProductUseCase(productRepository)
}

