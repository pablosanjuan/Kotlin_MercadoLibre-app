package com.pabloSanjuan.listadoproductos.data.di.module

import androidx.lifecycle.ViewModel
import com.pabloSanjuan.listadoproductos.data.di.annotation.ViewModelKey
import com.pabloSanjuan.listadoproductos.presentation.MainActivityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainActivityViewModel::class)
    abstract fun bindMainViewModel(mainActivityViewModel: MainActivityViewModel) : ViewModel
}