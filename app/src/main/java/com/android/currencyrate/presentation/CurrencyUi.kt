package com.android.currencyrate.presentation

import com.android.currencyrate.R
import com.android.currencyrate.core.Abstract
import com.android.currencyrate.core.Currency
import com.android.currencyrate.domain.ErrorType

sealed class CurrencyUi : Abstract.Object<Unit, Abstract.Mapper.Empty>() {


    class Success(
        private val communication: Communication,
        private val currency: Currency
    ) : CurrencyUi() {
        override fun map(mapper: Abstract.Mapper.Empty) = communication.show(currency)
    }

    class Failed(
        private val communication: Communication,
        private val errorType: ErrorType,
        private val resourceProvider: ResourceProvider
    ) : CurrencyUi() {
        override fun map(mapper: Abstract.Mapper.Empty) {
            val messageId = when (errorType) {
                ErrorType.NO_CONNECTION -> R.string.no_connection
                ErrorType.SERVICE_UNAVAILABLE -> R.string.service_unavailable
                else -> R.string.something_went_wrong
            }
            communication.show(resourceProvider.getMessage(messageId))
        }
    }

}