package com.edurda77.creditmarket.data.remote

import retrofit2.http.GET

interface CreditMarketApi {
    @GET("tops/main/api.json")
    suspend fun getData(
    ): List<CreditMarketDTO>
}