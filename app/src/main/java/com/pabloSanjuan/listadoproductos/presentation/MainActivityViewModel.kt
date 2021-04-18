package com.pabloSanjuan.listadoproductos.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabloSanjuan.listadoproductos.data.models.Products
import com.pabloSanjuan.listadoproductos.data.models.Result
import com.pabloSanjuan.listadoproductos.data.service.ProductsService
import com.pabloSanjuan.listadoproductos.domain.usescases.GetProductUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val context: Context,
    private val productsService: ProductsService,
    private val getProductUseCase: GetProductUseCase
) : ViewModel() {

    val productsList = MutableLiveData<List<Result>>()


    fun getData() {
        val params = HashMap<String, String>()
        params["category"] = "MLA1055"

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = getProductUseCase.invoke(GetProductUseCase.Params(params))
                response.let {
                    if(it.isSuccessful){
                        productsList.postValue(it.body()?.results)

                    }else{
                        it.errorBody()
                    }
                }
            }
        }
    }
}