package com.pabloSanjuan.listadoproductos.utils

import android.app.UiModeManager
import android.content.Context
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatDelegate
import com.pabloSanjuan.listadoproductos.R
import java.security.InvalidParameterException

class ThemeProvider(private val context: Context) {

    private val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun getThemeFromPreferences(): Int {
        val selectedTheme =
            sharedPreferences.getInt(context.getString(R.string.theme_preferences_key), 2)
        return getTheme(selectedTheme)
    }

    fun getTheme(selectedTheme: Int): Int = when (selectedTheme) {
        0 -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        1 -> UiModeManager.MODE_NIGHT_YES
        2 -> UiModeManager.MODE_NIGHT_NO
        else -> throw InvalidParameterException("Theme not defined for $selectedTheme")
    }

    fun setTheme(index: Int): Boolean {
        return if (getTheme(index) != getThemeFromPreferences()) {
            sharedPreferences.edit()
                .putInt(context.getString(R.string.theme_preferences_key), index).apply()
            true
        } else {
            false
        }
    }
}