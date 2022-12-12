package com.edurda77.creditmarket.data.mapper

import com.edurda77.creditmarket.data.remote.CreditMarketDTO
import com.edurda77.creditmarket.domain.entity.CreditMarketData

fun List<CreditMarketDTO>.convertToListCreditMarketData(): List<CreditMarketData> {
    return this.map {
        CreditMarketData(
            imageUrl = it.imageUrl,
            percent = it.percent,
            url = it.url,
            sumOne = it.sumOne
        )
    }
}