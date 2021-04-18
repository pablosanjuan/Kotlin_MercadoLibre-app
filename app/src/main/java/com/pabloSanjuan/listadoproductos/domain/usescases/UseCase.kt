package com.pabloSanjuan.listadoproductos.domain.usescases

import com.pabloSanjuan.listadoproductos.data.models.Products
import retrofit2.Response


interface UseCase<Type, in Params> where Type : Any {
    suspend operator fun invoke(params: Params): Response<Products>
}
