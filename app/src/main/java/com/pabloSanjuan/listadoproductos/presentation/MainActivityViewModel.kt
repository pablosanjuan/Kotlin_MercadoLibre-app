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

class MainActivityViewModel @Inject constructor() : ViewModel() {
}