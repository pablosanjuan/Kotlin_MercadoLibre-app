package com.pabloSanjuan.listadoproductos.data.di.module

import com.pabloSanjuan.listadoproductos.data.service.ProductsService
import com.pabloSanjuan.listadoproductos.utils.Constants
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Pablo Sanjuan
 *
 * Modulo de creacion de instancias de conexion para Retrofit
 */

@Module
class NetModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        val httpClientBuilder = OkHttpClient.Builder()
        httpClientBuilder.readTimeout(Constants.TIME_OUT_READ, TimeUnit.SECONDS)
        httpClientBuilder.connectTimeout(Constants.TIME_OUT_CONNECT, TimeUnit.SECONDS)
        return httpClientBuilder.build()
    }

    @Singleton
    @Provides
    fun provideHttpClient(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    fun provideAppService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }
}