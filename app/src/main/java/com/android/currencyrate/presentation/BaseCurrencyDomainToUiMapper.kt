package com.android.currencyrate.presentation

import com.android.currencyrate.core.Currency
import com.android.currencyrate.domain.CurrencyDomainToUiMapper
import com.android.currencyrate.domain.ErrorType

class BaseCurrencyDomainToUiMapper(
    private val communication: Communication,
    private val resourceProvider: ResourceProvider
) : CurrencyDomainToUiMapper {

    override fun map(currency: Currency): CurrencyUi {
       return CurrencyUi.Success(communication,currency)
    }

    override fun map(errorType: ErrorType): CurrencyUi {
        return CurrencyUi.Failed(communication,errorType,resourceProvider)
    }
}