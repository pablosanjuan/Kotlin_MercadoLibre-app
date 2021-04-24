package com.pabloSanjuan.listadoproductos.domain.usescases

import com.pabloSanjuan.listadoproductos.data.models.Products
import com.pabloSanjuan.listadoproductos.domain.repositories.SearchRepository
import retrofit2.Response

/**
 * Pablo Sanjuan
 *
 * Caso de Uso que define el objetivo que tiene una funcionalidad
 * partiendo de los principios SOLID -> The Single-responsibility principle
 */

class SearchUseCase(
    private val searchRepository: SearchRepository
) : UseCase<Products, SearchUseCase.Params> {

    override suspend fun invoke(params: Params): Response<Products> {
        return searchRepository.getSearchData(params.query)
    }

    data class Params(val query: HashMap<String, String>)
}
