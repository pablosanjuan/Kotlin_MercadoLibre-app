package com.pabloSanjuan.listadoproductos.data.models


import com.google.gson.annotations.SerializedName

data class AvailableSort(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)