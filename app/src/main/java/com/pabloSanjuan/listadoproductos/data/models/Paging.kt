package com.pabloSanjuan.listadoproductos.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Paging(
    @SerializedName("limit")
    val limit: Int?, // 1
    @SerializedName("offset")
    val offset: Int?, // 0
    @SerializedName("primary_results")
    val primaryResults: Int?, // 1000
    @SerializedName("total")
    val total: Int? // 600
) : Parcelable