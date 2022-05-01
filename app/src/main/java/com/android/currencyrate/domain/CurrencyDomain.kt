package com.android.currencyrate.domain

import com.android.currencyrate.core.Abstract
import com.android.currencyrate.core.Currency
import com.android.currencyrate.presentation.CurrencyUi
import retrofit2.HttpException
import java.net.UnknownHostException

sealed class CurrencyDomain: Abstract.Object<CurrencyUi,CurrencyDomainToUiMapper>() {

    class Success(private val currency: Currency): CurrencyDomain(){
        override fun map(mapper: CurrencyDomainToUiMapper): CurrencyUi {
          return  mapper.map(currency)
        }
    }

    class Failed(private val e: Exception): CurrencyDomain(){
        override fun map(mapper: CurrencyDomainToUiMapper): CurrencyUi {
            return mapper.map(
                when(e){
                    is UnknownHostException -> ErrorType.NO_CONNECTION
                    is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                    else -> ErrorType.GENERIC_ERROR
                }
            )
        }
    }
}