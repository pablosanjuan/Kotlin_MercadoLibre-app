package com.pabloSanjuan.listadoproductos.data.models


import com.google.gson.annotations.SerializedName

data class Claims(
    @SerializedName("period")
    val period: String,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("value")
    val value: Int
)