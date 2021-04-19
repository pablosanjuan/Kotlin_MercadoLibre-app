package com.pabloSanjuan.listadoproductos.presentation.base

import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.pabloSanjuan.listadoproductos.data.di.factory.ViewModelFactory
import com.pabloSanjuan.listadoproductos.presentation.MainActivityViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class BaseActivity <V : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelClass: Class<V>

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    //protected lateinit var binding: B
    protected lateinit var viewModel: V


    protected fun setAndBindContentView(@LayoutRes layoutResID: Int) {
        //binding = DataBindingUtil.setContentView(this, layoutResID)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }
}