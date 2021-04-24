package com.pabloSanjuan.listadoproductos.presentation.base

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pabloSanjuan.listadoproductos.data.di.factory.ViewModelFactory
import javax.inject.Inject

/**
 * Pablo Sanjuan
 *
 * Clase base para los fragments, tener mayor control y evitar escribir tanto codigo redundante
 * dentro de las diferentes activities
 *
 * Contiene:
 *
 * - Aqui recibo parametros genericos para construir ViewModels y ViewBindings de las difrentes
 * fragments
 *
 * - Cree un metodo para poder analizar la disponibilidad de internet en los diferentes
 * fragments
 */

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

    fun isNetworkOnline(context: Context): Boolean {
        var isOnline = false
        try {
            val manager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            val capabilities = manager?.getNetworkCapabilities(manager.activeNetwork) // need ACCESS_NETWORK_STATE permission
            isOnline = capabilities != null && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return isOnline
    }
}