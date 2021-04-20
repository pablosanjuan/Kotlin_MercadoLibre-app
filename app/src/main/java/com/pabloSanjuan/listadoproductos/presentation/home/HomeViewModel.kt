package com.pabloSanjuan.listadoproductos.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabloSanjuan.listadoproductos.data.models.Result
import com.pabloSanjuan.listadoproductos.domain.usescases.SearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
): ViewModel() {

    val productsList = MutableLiveData<List<Result>>()

    fun getData(query: String) {
        val params = HashMap<String, String>()
        params["q"] = query

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = searchUseCase.invoke(SearchUseCase.Params(params))
                response.let {
                    if(it.isSuccessful){
                        productsList.postValue(it.body()?.results)
                        this@launch.cancel()
                    }else{
                        it.errorBody()
                    }
                }
            }
        }
    }
}