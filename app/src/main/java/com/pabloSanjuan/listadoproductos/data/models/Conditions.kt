package com.pabloSanjuan.listadoproductos.data.models


import com.google.gson.annotations.SerializedName

data class Conditions(
    @SerializedName("context_restrictions")
    val contextRestrictions: List<Any>,
    @SerializedName("eligible")
    val eligible: Boolean,
    @SerializedName("end_time")
    val endTime: Any,
    @SerializedName("start_time")
    val startTime: Any
)