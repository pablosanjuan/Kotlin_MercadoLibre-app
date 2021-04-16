package com.pabloSanjuan.listadoproductos.data.models


import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("available_filters")
    val availableFilters: List<AvailableFilter>,
    @SerializedName("available_sorts")
    val availableSorts: List<AvailableSort>,
    @SerializedName("filters")
    val filters: List<Filter>,
    @SerializedName("paging")
    val paging: Paging,
    @SerializedName("query")
    val query: String,
    @SerializedName("related_results")
    val relatedResults: List<Any>,
    @SerializedName("results")
    val results: List<Result>,
    @SerializedName("secondary_results")
    val secondaryResults: List<Any>,
    @SerializedName("site_id")
    val siteId: String,
    @SerializedName("sort")
    val sort: Sort
)