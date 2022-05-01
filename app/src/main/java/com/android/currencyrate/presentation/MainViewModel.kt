package com.android.currencyrate.presentation

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.currencyrate.core.Abstract
import com.android.currencyrate.core.Currency
import com.android.currencyrate.domain.CurrencyDomainToUiMapper
import com.android.currencyrate.domain.Interactor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(
    private val communication: Communication,
    private val interactor: Interactor,
    private val mapper: CurrencyDomainToUiMapper
) : ViewModel() {


    fun getCurrency() = viewModelScope.launch(Dispatchers.IO) {
        val resultDomain = interactor.getCurrency()
        withContext(Dispatchers.Main) {
            val resultUi = resultDomain.map(mapper)
            resultUi.map(Abstract.Mapper.Empty())
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<Currency>){
        communication.observeSuccess(owner, observer)
    }

}