package com.pabloSanjuan.listadoproductos.data.service

import com.pabloSanjuan.listadoproductos.data.models.Products
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ProductsService{

    //https://api.mercadolibre.com/sites/MLA/search?category=MLA1055
    @GET("sites/MLA/search?limit=1")
    suspend fun searchByCategory(
        @Query("category") category: String
    ): Response<Products>


    //https://api.mercadolibre.com/sites/MLA/search?q=Motorola%20G6
    @GET("sites/MLA/search?")
    suspend fun searchByQuery(
        @QueryMap query: HashMap<String, String>
    ): Response<Products>

}