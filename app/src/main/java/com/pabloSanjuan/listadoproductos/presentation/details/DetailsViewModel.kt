package com.pabloSanjuan.listadoproductos.presentation.details

import androidx.lifecycle.ViewModel
import com.pabloSanjuan.listadoproductos.data.models.Result
import javax.inject.Inject

class DetailsViewModel @Inject constructor() : ViewModel() {

    /**
     * Pablo Sanjuan
     *
     * Contiene data class para ampear el parametro result que viene del
     * Home fragment al hacer click
     */

    data class ProductModel(
        val result: Result
    )
}