package com.pabloSanjuan.listadoproductos.utils.ktx

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.pabloSanjuan.listadoproductos.R
import kotlinx.android.synthetic.main.item_product.view.*

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

var View.visible: Boolean
    get() = this.visibility == View.VISIBLE
    set(isVisible) {
        this.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

@BindingAdapter("imageResource")
fun setImageResource(view: ImageView, imageUrl: String?) {

    if (!imageUrl.isNullOrBlank()) {
        Glide.with(view)
            .load(imageUrl)
            .placeholder(R.drawable.ic_baseline_image_24)
            .error(R.drawable.ic_baseline_broken_image_24)
            .into(view)
    }
}