package com.pabloSanjuan.listadoproductos.data.models


import com.google.gson.annotations.SerializedName

data class SellerReputation(
    @SerializedName("level_id")
    val levelId: String,
    @SerializedName("metrics")
    val metrics: Metrics,
    @SerializedName("power_seller_status")
    val powerSellerStatus: Any,
    @SerializedName("transactions")
    val transactions: Transactions
)