package com.pabloSanjuan.listadoproductos.data.models


import com.google.gson.annotations.SerializedName

data class Ratings(
    @SerializedName("negative")
    val negative: Double,
    @SerializedName("neutral")
    val neutral: Float,
    @SerializedName("positive")
    val positive: Double
)