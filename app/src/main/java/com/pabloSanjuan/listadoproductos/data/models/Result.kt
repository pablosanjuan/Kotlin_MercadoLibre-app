package com.pabloSanjuan.listadoproductos.data.models

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class Result(
    @SerializedName("accepts_mercadopago")
    val acceptsMercadopago: Boolean? = false, // true
    @SerializedName("address")
    val address: Address? = Address(),
    @SerializedName("available_quantity")
    val availableQuantity: Int? = 0, // 2
    @SerializedName("buying_mode")
    val buyingMode: String? = "", // buy_it_now
    @SerializedName("catalog_listing")
    val catalogListing: Boolean? = false, // true
    @SerializedName("catalog_product_id")
    val catalogProductId: String? = "", // MLA9652754
    @SerializedName("category_id")
    val categoryId: String? = "", // MLA1055
    @SerializedName("condition")
    val condition: String? = "", // new
    @SerializedName("currency_id")
    val currencyId: String? = "", // ARS
    @SerializedName("differential_pricing")
    val differentialPricing: DifferentialPricing? = DifferentialPricing(),
    @SerializedName("domain_id")
    val domainId: String? = "", // MLA-CELLPHONES
    @SerializedName("id")
    val id: String? = "", // MLA908821963
    @SerializedName("installments")
    val installments: Installments? = Installments(),
    @SerializedName("listing_type_id")
    val listingTypeId: String? = "", // gold_pro
    @SerializedName("order_backend")
    val orderBackend: Int? = 0, // 1
    @SerializedName("permalink")
    val permalink: String? = "", // https://www.mercadolibre.com.ar/moto-g6-32-gb-indigo-oscuro-3-gb-ram/p/MLA9652754
    @SerializedName("price")
    val price: Float? = 0f, // 40000
    @SerializedName("prices")
    val prices: Prices? = Prices(),
    @SerializedName("seller")
    val seller: Seller? = Seller(),
    @SerializedName("seller_address")
    val sellerAddress: SellerAddress? = SellerAddress(),
    @SerializedName("shipping")
    val shipping: Shipping? = Shipping(),
    @SerializedName("site_id")
    val siteId: String? = "", // MLA
    @SerializedName("sold_quantity")
    val soldQuantity: Int? = 0, // 0
    @SerializedName("stop_time")
    val stopTime: String? = "", // 2041-02-13T04:00:00.000Z
    @SerializedName("thumbnail")
    val thumbnail: String? = "", // http://http2.mlstatic.com/D_632562-MLA31003470563_062019-I.jpg
    @SerializedName("thumbnail_id")
    val thumbnailId: String? = "", // 632562-MLA31003470563_062019
    @SerializedName("title")
    val title: String? = "", // Moto G6 32 Gb Índigo Oscuro 3 Gb Ram
    @SerializedName("use_thumbnail_id")
    val useThumbnailId: Boolean? = false // true
) : Parcelable