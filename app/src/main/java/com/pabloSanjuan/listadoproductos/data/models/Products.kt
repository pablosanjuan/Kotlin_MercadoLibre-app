package com.pabloSanjuan.listadoproductos.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Products(
    @SerializedName("paging")
    val paging: Paging?,
    @SerializedName("query")
    val query: String?, // Motorola G6
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("site_id")
    val siteId: String? // MLA
) : Parcelable