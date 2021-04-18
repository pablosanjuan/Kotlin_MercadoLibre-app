package com.pabloSanjuan.listadoproductos.domain.usescases

import com.pabloSanjuan.listadoproductos.data.models.Products
import com.pabloSanjuan.listadoproductos.domain.repositories.ProductRepository
import retrofit2.Response

class GetProductUseCase(
    private val productRepository: ProductRepository
) : UseCase<Products, GetProductUseCase.Params> {

    override suspend fun invoke(params: Params): Response<Products> {
        return productRepository.getProductData(params.query)
    }

    data class Params(val query: HashMap<String, String>)
}
