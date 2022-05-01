package com.android.currencyrate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.currencyrate.core.App
import com.android.currencyrate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = (applicationContext as App).viewModel

        viewModel.observe(this){
            binding.euroCurrency.text = it.currencies[0].second
            binding.usdCurrency.text = it.currencies[1].second
        }
        viewModel.getCurrency()

    }
}