package com.android.currencyrate.presentation

import android.content.Context
import androidx.annotation.StringRes

interface ResourceProvider {

    fun getMessage(@StringRes id: Int): String


    class Base(private val context: Context): ResourceProvider{
        override fun getMessage(id: Int): String {
            return context.getString(id)
        }
    }

}