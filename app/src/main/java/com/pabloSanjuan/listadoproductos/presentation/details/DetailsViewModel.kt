package com.pabloSanjuan.listadoproductos.presentation.details

import androidx.lifecycle.ViewModel
import com.pabloSanjuan.listadoproductos.data.models.Result
import javax.inject.Inject

class DetailsViewModel @Inject constructor() : ViewModel() {

    data class ProductModel(
        val result: Result
    )
}