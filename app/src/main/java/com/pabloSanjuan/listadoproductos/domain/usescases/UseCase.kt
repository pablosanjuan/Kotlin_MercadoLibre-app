package com.pabloSanjuan.listadoproductos.domain.usescases

import com.pabloSanjuan.listadoproductos.data.models.Products
import retrofit2.Response

/**
 * Pablo Sanjuan
 *
 * CLASE BASE PARA HEREDAR UNA UNICA FUNCIONALIDAD POR CLASE
 * partiendo de los principios SOLID -> The Single-responsibility principle
 */

interface UseCase<Type, in Params> where Type : Any {
    suspend operator fun invoke(params: Params): Response<Products>
}
