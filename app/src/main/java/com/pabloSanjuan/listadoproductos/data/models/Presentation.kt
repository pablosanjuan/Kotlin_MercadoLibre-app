package com.pabloSanjuan.listadoproductos.data.models


import com.google.gson.annotations.SerializedName

data class Presentation(
    @SerializedName("display_currency")
    val displayCurrency: String
)