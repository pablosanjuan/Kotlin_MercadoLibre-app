package com.pabloSanjuan.listadoproductos.data.di.module

import com.pabloSanjuan.listadoproductos.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class, FragmentsBuilderModule::class])
    abstract fun contributesInjectMainActivity(): MainActivity
}