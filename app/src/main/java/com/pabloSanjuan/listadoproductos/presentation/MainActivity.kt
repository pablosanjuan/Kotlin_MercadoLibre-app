package com.pabloSanjuan.listadoproductos.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.data.service.ProductsService
import com.pabloSanjuan.listadoproductos.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doARequest()
    }

    private fun doARequest() {
        val retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
        val productService = retrofit.create(ProductsService::class.java)
        CoroutineScope(Dispatchers.IO).launch {
            val response = productService.searchByCategory("MLA1055")
            withContext(Dispatchers.Main){
                Log.d("pablo_tag", "$response")
            }

        }
    }
}