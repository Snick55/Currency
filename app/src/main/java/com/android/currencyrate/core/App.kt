package com.android.currencyrate.core

import android.app.Application
import com.android.currencyrate.data.CloudCurrencyMapper
import com.android.currencyrate.data.CloudDataSource
import com.android.currencyrate.data.Repository
import com.android.currencyrate.data.cloud.ApiService
import com.android.currencyrate.data.cloud.CloudToCurrencyMapper
import com.android.currencyrate.domain.BaseCurrencyToDomainMapper
import com.android.currencyrate.domain.Interactor
import com.android.currencyrate.presentation.BaseCurrencyDomainToUiMapper
import com.android.currencyrate.presentation.Communication
import com.android.currencyrate.presentation.MainViewModel
import com.android.currencyrate.presentation.ResourceProvider
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App: Application() {

lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder().baseUrl("https://currate.ru/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)

        val cloudDataSource = CloudDataSource.Base(service)
        val cloudCurrencyMapper = CloudCurrencyMapper.Base(CloudToCurrencyMapper.Base())

        val repository = Repository.Base(
            cloudDataSource,
            cloudCurrencyMapper
        )

        val dataToDomainMapper = BaseCurrencyToDomainMapper()
        val interactor = Interactor.Base(repository,dataToDomainMapper)
        val communication = Communication.Base()

        val domainToUiMapper = BaseCurrencyDomainToUiMapper(communication,ResourceProvider.Base(this))
        viewModel = MainViewModel(
            communication,
            interactor,
            domainToUiMapper
        )

    }

}