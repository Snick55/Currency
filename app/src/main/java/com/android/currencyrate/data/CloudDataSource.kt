package com.android.currencyrate.data

import android.util.Log
import com.android.currencyrate.data.cloud.ApiService
import com.android.currencyrate.data.cloud.Json

interface CloudDataSource {

    suspend fun getCurrency():Json


    class Base(private val service: ApiService): CloudDataSource{
        override suspend fun getCurrency(): Json{
            Log.d("TAG",":::::::::${service.getCurrencyRate()}")
           return service.getCurrencyRate()
        }
    }
}