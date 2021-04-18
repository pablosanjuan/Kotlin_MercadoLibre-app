package com.pabloSanjuan.listadoproductos.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabloSanjuan.listadoproductos.data.service.ProductsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val context: Context,
    private val productsService: ProductsService
) : ViewModel() {
    fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = productsService.searchByCategory("MLA1055")
                withContext(Dispatchers.Main) {
                    Log.d("pablo_tag", "$response")
                }
            }
        }
    }
}