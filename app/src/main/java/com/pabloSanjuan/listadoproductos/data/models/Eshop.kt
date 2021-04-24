package com.pabloSanjuan.listadoproductos.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Eshop(
    @SerializedName("nick_name")
    val nick_name: String? = ""
) : Parcelable