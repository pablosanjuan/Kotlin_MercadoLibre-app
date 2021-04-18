package com.pabloSanjuan.listadoproductos.presentation

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.data.di.factory.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    lateinit var mainActivityViewModel : MainActivityViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityViewModel = ViewModelProviders.of(this,viewModelFactory).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getData()

    }
}