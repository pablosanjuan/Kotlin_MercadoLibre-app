package com.pabloSanjuan.listadoproductos.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pabloSanjuan.listadoproductos.data.models.Result
import com.pabloSanjuan.listadoproductos.domain.usescases.GetSearchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val getSearchUseCase: GetSearchUseCase
) : ViewModel() {

    val productsList = MutableLiveData<List<Result>>()

    fun getData() {
        val params = HashMap<String, String>()
        params["category"] = "MLA1055"

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val response = getSearchUseCase.invoke(GetSearchUseCase.Params(params))
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