package com.pabloSanjuan.listadoproductos.domain.usescases

import com.pabloSanjuan.listadoproductos.data.models.Products
import com.pabloSanjuan.listadoproductos.domain.repositories.SearchRepository
import retrofit2.Response

class GetSearchUseCase(
    private val searchRepository: SearchRepository
) : UseCase<Products, GetSearchUseCase.Params> {

    override suspend fun invoke(params: Params): Response<Products> {
        return searchRepository.getSearchData(params.query)
    }

    data class Params(val query: HashMap<String, String>)
}
