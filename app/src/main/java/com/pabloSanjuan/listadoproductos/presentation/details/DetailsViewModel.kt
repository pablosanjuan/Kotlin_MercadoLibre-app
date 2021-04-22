package com.pabloSanjuan.listadoproductos.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pabloSanjuan.listadoproductos.data.models.Result
import javax.inject.Inject

class DetailsViewModel @Inject constructor(): ViewModel(){

    private val _resultLiveData : MutableLiveData<Result> = MutableLiveData()
    val resultLiveData: LiveData<Result> get() = _resultLiveData

    fun intanceResult(result: Result) {
        _resultLiveData.postValue(result)
    }

}