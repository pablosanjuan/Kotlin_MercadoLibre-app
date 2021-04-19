package com.pabloSanjuan.listadoproductos.domain.repositories

import com.pabloSanjuan.listadoproductos.data.models.Products
import retrofit2.Response

interface SearchRepository {
    suspend fun getSearchData(query: HashMap<String, String>): Response<Products>
}