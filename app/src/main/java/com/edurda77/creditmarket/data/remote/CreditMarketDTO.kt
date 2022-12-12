package com.edurda77.creditmarket.data.remote


import com.google.gson.annotations.SerializedName

data class CreditMarketDTO(
    @SerializedName("image_url")
    val imageUrl: String,
    @SerializedName("percent")
    val percent: String,
    @SerializedName("sum_one")
    val sumOne: String,
    @SerializedName("url")
    val url: String
)