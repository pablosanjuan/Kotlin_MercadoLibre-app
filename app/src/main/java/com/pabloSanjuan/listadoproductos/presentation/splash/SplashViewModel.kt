package com.pabloSanjuan.listadoproductos.presentation.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SplashViewModel @Inject constructor(): ViewModel() {

    val productsList = MutableLiveData<Boolean>()

    fun delay(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                delay(3000)
                productsList.postValue(true)
            }
        }
    }
}