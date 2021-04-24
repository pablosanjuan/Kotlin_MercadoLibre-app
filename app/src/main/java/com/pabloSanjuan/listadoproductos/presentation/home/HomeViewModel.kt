package com.pabloSanjuan.listadoproductos.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.HttpException
import com.pabloSanjuan.listadoproductos.data.models.Products
import com.pabloSanjuan.listadoproductos.domain.usescases.SearchUseCase
import com.pabloSanjuan.listadoproductos.utils.Constants
import kotlinx.coroutines.*
import java.io.IOException
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : ViewModel() {

    private val _serverIssueLiveData : MutableLiveData<String> = MutableLiveData()
    val serverIssueLiveData: LiveData<String> get() = _serverIssueLiveData

    private val _noInternetLiveData : MutableLiveData<String> = MutableLiveData()
    val noInternetLiveData: LiveData<String> get() = _noInternetLiveData

    private val _productsList : MutableLiveData<Products> = MutableLiveData()
    val productsList: LiveData<Products> get() = _productsList

    fun getData(query: String, isInternetAvailable: Boolean) {
        val params = HashMap<String, String>()
        params["q"] = query
        if (isInternetAvailable) {
            viewModelScope.launch {
                try {
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
                    /**
                     * SERVER ERROR HANDLER
                     *
                     * con este bloque podemos manejar erroes a nivel de Server
                     * realize algo basico pero se pueden crear clases de
                     * Failure para manejar estas excepciones
                     */

                } catch (ce: CancellationException) {
                    Log.e(Constants.TAG, ce.toString())
                } catch (e: Exception) {
                    e.printStackTrace()
                    catchError("[E] ${e.message}")
                } catch (ioe: IOException) {
                    catchError("[IOE] ${ioe.message}")
                } catch (http: HttpException) {
                    catchError("[HTTP] ${http.message}")

                }
            }
        } else {
            _noInternetLiveData.postValue("No hay conexion a Internet")
        }
    }

    private fun catchError(message: String?) {
        _noInternetLiveData.postValue("Algo salio mal\nintenta de nuevo")
        _serverIssueLiveData.postValue(message)
    }
}