package com.pabloSanjuan.listadoproductos.utils.ktx

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

var View.visible: Boolean
    get() = this.visibility == View.VISIBLE
    set(isVisible) {
        this.visibility = if (isVisible) View.VISIBLE else View.GONE
    }