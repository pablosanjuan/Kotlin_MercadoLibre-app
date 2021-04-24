package com.pabloSanjuan.listadoproductos.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabloSanjuan.listadoproductos.data.models.Products
import com.pabloSanjuan.listadoproductos.domain.usescases.SearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _internetIssueLiveData : MutableLiveData<Boolean> = MutableLiveData()
    val internetIssueLiveData: LiveData<Boolean> get() = _internetIssueLiveData

    private val _productsList : MutableLiveData<Products> = MutableLiveData()
    val productsList: LiveData<Products> get() = _productsList

    fun getData(query: String, isInternetAvailable: Boolean) {
        val params = HashMap<String, String>()
        params["q"] = query
        if (isInternetAvailable) {
            viewModelScope.launch {
                withContext(Dispatchers.IO) {
                    val response = searchUseCase.invoke(SearchUseCase.Params(params))
                    response.let {
                        if (it.isSuccessful) {
                            _productsList.postValue(it.body())
                            this@launch.cancel()
                        } else {
                            it.errorBody()
                        }
                    }
                }
            }
        } else {
            _internetIssueLiveData.postValue(true)
        }
    }
}