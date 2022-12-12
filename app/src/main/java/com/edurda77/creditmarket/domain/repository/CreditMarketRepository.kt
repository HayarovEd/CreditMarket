package com.edurda77.creditmarket.domain.repository

import com.edurda77.creditmarket.domain.entity.CreditMarketData
import com.edurda77.creditmarket.domain.utils.Resource

interface CreditMarketRepository {
    suspend fun getAllData() : Resource<List<CreditMarketData>>
}