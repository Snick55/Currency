package com.android.currencyrate.data.cloud

import com.android.currencyrate.core.Abstract
import com.android.currencyrate.core.Currency

interface CloudToCurrencyMapper : Abstract.Mapper {
    fun map(message: String, currencies: Map<String, String>): Currency


    class Base : CloudToCurrencyMapper {
        override fun map(message: String, currencies: Map<String, String>): Currency {
            val result = currencies.map { Pair(it.key, it.value) }.toList()
            return Currency(message,result)
        }
    }
}