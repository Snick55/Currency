package com.android.currencyrate.data

import com.android.currencyrate.core.Abstract
import com.android.currencyrate.core.Currency
import com.android.currencyrate.domain.CurrencyDomain

sealed class CurrencyData: Abstract.Object<CurrencyDomain,CurrencyDataToDomainMapper> () {

    class Success(private val currency: Currency) : CurrencyData() {
        override fun map(mapper: CurrencyDataToDomainMapper): CurrencyDomain {
            return mapper.map(currency)
        }
    }
        class Failed(private val e: Exception) : CurrencyData() {
            override fun map(mapper: CurrencyDataToDomainMapper): CurrencyDomain {
                return mapper.map(e)
            }
        }
    }


