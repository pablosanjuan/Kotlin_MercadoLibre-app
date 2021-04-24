package com.pabloSanjuan.listadoproductos.presentation.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Pablo Sanjuan
 *
 * - Por medio de una Suspend Function hago que la app se quede en segundo plano
 *  realizando un delay para crear un splash
 *
 * - el Job de la coroutine se destruye con el ciclo de vida del VM
 */

class SplashViewModel @Inject constructor(): ViewModel() {

    private val _productsList : MutableLiveData<Boolean> = MutableLiveData()
    val productsList: LiveData<Boolean> get() = _productsList
    companion object{
        const val DELAY_TIME = 3000L
    }

    fun delay(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                delay(DELAY_TIME)
                _productsList.postValue(true)
            }
        }
    }
}