package com.pabloSanjuan.listadoproductos.data.service

import com.pabloSanjuan.listadoproductos.data.models.Products
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsService{

    //https://api.mercadolibre.com/sites/MLA/search?category=MLA1055
    @GET("sites/MLA/seaarch?limit=1")
    suspend fun searchByCategory(
        @Query("category") category: String
    ): Products


    //https://api.mercadolibre.com/sites/MLA/search?q=Motorola%20G6
    @GET("sites/MLA/search?")
    suspend fun searchByProduct(
        @Query("q") q: String
    ): Products

}