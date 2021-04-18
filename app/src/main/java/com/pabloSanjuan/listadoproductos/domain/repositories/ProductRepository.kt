package com.pabloSanjuan.listadoproductos.domain.repositories

import com.pabloSanjuan.listadoproductos.data.models.Products
import retrofit2.Response

interface ProductRepository {
    suspend fun getProductData(query: HashMap<String, String>): Response<Products>
}