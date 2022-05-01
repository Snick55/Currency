package com.android.currencyrate.data


interface Repository {

    suspend fun getCurrency():CurrencyData


    class Base(
    private val cloudDataSource: CloudDataSource,
    private val cloudCurrencyMapper: CloudCurrencyMapper
    ): Repository{
        override suspend fun getCurrency(): CurrencyData {
            return try {
                val currencyCloud = cloudDataSource.getCurrency()
                val currency = cloudCurrencyMapper.map(currencyCloud)
                CurrencyData.Success(currency)
            }catch (e: Exception){
                CurrencyData.Failed(e)
            }
        }
    }
}