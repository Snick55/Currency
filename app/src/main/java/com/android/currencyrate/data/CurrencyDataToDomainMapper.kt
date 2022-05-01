package com.android.currencyrate.data

import com.android.currencyrate.core.Abstract
import com.android.currencyrate.core.Currency
import com.android.currencyrate.domain.CurrencyDomain

interface CurrencyDataToDomainMapper: Abstract.Mapper {

    fun map(currency: Currency):CurrencyDomain
    fun map(e: Exception): CurrencyDomain

}