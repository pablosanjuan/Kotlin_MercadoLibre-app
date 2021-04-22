package com.pabloSanjuan.listadoproductos.presentation.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pabloSanjuan.listadoproductos.data.di.factory.ViewModelFactory
import javax.inject.Inject

abstract class BaseFragment <V, B> : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected inline fun <reified V : ViewModel> initViewModel(): V {
        return getViewModel(V::class.java)
    }

    protected fun <V : ViewModel> getViewModel(modelClass: Class<V>): V {
        return ViewModelProvider(this, viewModelFactory).get(modelClass)
    }

    private var _binding: B? = null
    protected var binding
        get() = _binding!!
        set(value) {
            _binding = value
        }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}