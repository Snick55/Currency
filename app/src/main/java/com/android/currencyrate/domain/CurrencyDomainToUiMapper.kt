package com.android.currencyrate.domain

import com.android.currencyrate.core.Abstract
import com.android.currencyrate.core.Currency
import com.android.currencyrate.presentation.CurrencyUi

interface CurrencyDomainToUiMapper: Abstract.Mapper {

    fun map(currency: Currency):CurrencyUi
    fun map(errorType: ErrorType): CurrencyUi
}