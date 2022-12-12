package com.edurda77.creditmarket.presentation

import com.edurda77.creditmarket.domain.entity.CreditMarketData

sealed interface MainViewState {
    object Loading : MainViewState
    class Failure(val error:String) : MainViewState
    class Success(val data: List<CreditMarketData>) : MainViewState
}