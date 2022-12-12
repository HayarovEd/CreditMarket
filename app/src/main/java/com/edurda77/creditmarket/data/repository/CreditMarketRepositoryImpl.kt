package com.edurda77.creditmarket.data.repository

import com.edurda77.creditmarket.data.mapper.convertToListCreditMarketData
import com.edurda77.creditmarket.data.remote.CreditMarketApi
import com.edurda77.creditmarket.domain.entity.CreditMarketData
import com.edurda77.creditmarket.domain.repository.CreditMarketRepository
import com.edurda77.creditmarket.domain.utils.DESCRIPTION_ERROR
import com.edurda77.creditmarket.domain.utils.Resource
import javax.inject.Inject

class CreditMarketRepositoryImpl @Inject constructor(private val api: CreditMarketApi) :
    CreditMarketRepository {
    override suspend fun getAllData(): Resource<List<CreditMarketData>> {
        return try {
            Resource.Success(
                data = api.getData(
                ).convertToListCreditMarketData()
            )
        } catch(e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: DESCRIPTION_ERROR)
        }
    }
}