package com.edurda77.creditmarket.di

import com.edurda77.creditmarket.data.repository.CreditMarketRepositoryImpl
import com.edurda77.creditmarket.domain.repository.CreditMarketRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCreditMarketRepository(
        creditMarketRepositoryImpl: CreditMarketRepositoryImpl
    ): CreditMarketRepository
}