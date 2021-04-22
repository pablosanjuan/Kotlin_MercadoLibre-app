package com.pabloSanjuan.listadoproductos.presentation.config

import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pabloSanjuan.listadoproductos.data.models.Products
import com.pabloSanjuan.listadoproductos.utils.ThemeProvider
import javax.inject.Inject

class ConfigViewModel @Inject constructor(): ViewModel(){

    val themeIndex = MutableLiveData<Int>()
    @Inject
    lateinit var themeProvider: ThemeProvider

    fun getThemeIndex(): Int{
        return themeProvider.getThemeFromPreferences()
    }

    fun setThemeIndex(index: Int) {
        themeProvider.setTheme(index)
        val indexAppDelegate = when(index){
            0 -> 1
            1 -> -1
            2 -> 2
            else -> -1
        }
        themeIndex.postValue(indexAppDelegate)
        changeTheme(indexAppDelegate)
    }

    private fun changeTheme(index: Int) {
        AppCompatDelegate.setDefaultNightMode(index)
    }
}