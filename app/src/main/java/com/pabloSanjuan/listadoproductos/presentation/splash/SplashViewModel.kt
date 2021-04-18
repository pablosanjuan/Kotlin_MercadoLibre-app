package com.pabloSanjuan.listadoproductos.presentation.splash

import android.content.Context
import androidx.lifecycle.ViewModel
import com.pabloSanjuan.listadoproductos.data.service.ProductsService
import com.pabloSanjuan.listadoproductos.domain.usescases.GetProductUseCase
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val context: Context,
    private val productsService: ProductsService,
    private val getProductUseCase: GetProductUseCase
): ViewModel() {
}