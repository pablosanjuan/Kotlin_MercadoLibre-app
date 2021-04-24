package com.pabloSanjuan.listadoproductos.domain.repositories

import com.pabloSanjuan.listadoproductos.data.models.Products
import retrofit2.Response

/**
 * Pablo Sanjuan
 *
 * Implementacion del patron Repository que permite crear instancias del Service
 * aqui definimos las acciones o funcionalidades que se quieren hacer
 * se definen los puentes a traves de los modulos de Clean Architecture
 */

interface SearchRepository {
    suspend fun getSearchData(query: HashMap<String, String>): Response<Products>
}