package com.pabloSanjuan.listadoproductos.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pabloSanjuan.listadoproductos.data.di.factory.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity <T> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected inline fun <reified T : ViewModel> initViewModel(): T {
        return getViewModel(T::class.java)
    }

    protected fun <T : ViewModel> getViewModel(modelClass: Class<T>): T {
        return ViewModelProvider(this, viewModelFactory).get(modelClass)
    }
}