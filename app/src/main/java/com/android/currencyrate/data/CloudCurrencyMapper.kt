package com.android.currencyrate.data

import com.android.currencyrate.core.Abstract
import com.android.currencyrate.core.Currency
import com.android.currencyrate.data.cloud.CloudToCurrencyMapper
import com.android.currencyrate.data.cloud.Json

interface CloudCurrencyMapper: Abstract.Mapper {

    fun map(cloudCurrency: Json): Currency


    class Base(private val currencyMapper: CloudToCurrencyMapper): CloudCurrencyMapper{
        override fun map(cloudCurrency: Json): Currency {
         return cloudCurrency.map(currencyMapper)
        }
    }

}