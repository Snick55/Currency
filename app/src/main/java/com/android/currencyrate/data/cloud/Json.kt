package com.android.currencyrate.data.cloud

import com.android.currencyrate.core.Abstract
import com.android.currencyrate.core.Currency
import com.google.gson.annotations.SerializedName

data class Json(
    @SerializedName("data")
    val data: Map<String,String>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
): Abstract.Object<Currency, CloudToCurrencyMapper>() {
    override fun map(mapper: CloudToCurrencyMapper): Currency = mapper.map(message,data)
}