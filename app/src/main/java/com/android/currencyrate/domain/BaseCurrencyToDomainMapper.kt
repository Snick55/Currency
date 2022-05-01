package com.android.currencyrate.domain

import com.android.currencyrate.core.Currency
import com.android.currencyrate.data.CurrencyDataToDomainMapper

class BaseCurrencyToDomainMapper: CurrencyDataToDomainMapper {
    override fun map(currency: Currency): CurrencyDomain {
        return CurrencyDomain.Success(currency)
    }

    override fun map(e: Exception): CurrencyDomain {
        return CurrencyDomain.Failed(e)
    }
}