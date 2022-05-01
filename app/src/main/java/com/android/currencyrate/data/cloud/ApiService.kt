package com.android.currencyrate.data.cloud

import retrofit2.http.GET
import retrofit2.http.Query

//https://currate.ru/api/?get=rates&pairs=USDRUB,EURRUB&key=af6ed355a93572de0d6fd4abf5dc43b8
interface ApiService {
    @GET("/api/?get=rates&pairs=USDRUB,EURRUB&")
    suspend fun getCurrencyRate(@Query("key") key: String = "af6ed355a93572de0d6fd4abf5dc43b8"): Json

}