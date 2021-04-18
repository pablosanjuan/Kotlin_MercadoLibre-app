package com.pabloSanjuan.listadoproductos.data.di.repositories

import com.pabloSanjuan.listadoproductos.data.models.Products
import com.pabloSanjuan.listadoproductos.data.service.ProductsService
import com.pabloSanjuan.listadoproductos.domain.repositories.ProductRepository
import retrofit2.Response

class ProductRepositoryImpl (
    private val productsService: ProductsService
): ProductRepository {
    override suspend fun getProductData(query: HashMap<String, String>): Response<Products> {
        return productsService.searchByQuery(query)
    }
}