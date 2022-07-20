package com.android.currencyrate.presentation

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.android.currencyrate.core.Currency

interface Communication {

    fun show(currency: Currency)
    fun show(errorMessage: String)
    fun observeError(owner: LifecycleOwner, observer: Observer<String>)
    fun observeSuccess(owner: LifecycleOwner, observer: Observer<Currency>)


    class Base : Communication {
        private val successLiveData = MutableLiveData<Currency>()

        private val errorLiveData = MutableLiveData<String>()


        override fun show(currency: Currency) {
            successLiveData.value = currency
            Log.d("TAG", "::::::::liveData Value is ${successLiveData.value}")
        }

        override fun show(errorMessage: String) {
            errorLiveData.value = errorMessage
        }

        override fun observeError(owner: LifecycleOwner, observer: Observer<String>) {
            errorLiveData.observe(owner, observer)
        }

        override fun observeSuccess(owner: LifecycleOwner, observer: Observer<Currency>) {
            successLiveData.observe(owner, observer)
        }
    }

}