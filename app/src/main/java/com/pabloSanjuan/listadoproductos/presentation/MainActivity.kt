package com.pabloSanjuan.listadoproductos.presentation

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.data.di.factory.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    lateinit var viewModel : MainActivityViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.getData()


        viewModel.productsList.observe(this, Observer {
            val ss = it
        })

    }
}