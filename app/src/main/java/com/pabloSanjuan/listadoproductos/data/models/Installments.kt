package com.pabloSanjuan.listadoproductos.data.models


import com.google.gson.annotations.SerializedName

data class Installments(
    @SerializedName("amount")
    val amount: Double,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("rate")
    val rate: Double
)