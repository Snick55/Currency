package com.android.currencyrate.domain

import com.android.currencyrate.data.CurrencyDataToDomainMapper
import com.android.currencyrate.data.Repository

interface Interactor {

    suspend fun getCurrency(): CurrencyDomain

    class Base(
        private val repository: Repository,
        private val mapper: CurrencyDataToDomainMapper
    ): Interactor{
        override suspend fun getCurrency(): CurrencyDomain {
            return repository.getCurrency().map(mapper)
        }
    }

}