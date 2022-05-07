package com.android.currencyrate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.currencyrate.core.App
import com.android.currencyrate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = (applicationContext as App).viewModel

        init()

        viewModel.observeSuccess(this) {
            binding.textView2.visibility = View.VISIBLE
            binding.textView3.visibility = View.VISIBLE
            binding.euroCurrency.text = it.currencies[0].second
            binding.usdCurrency.text = it.currencies[1].second
            binding.progressBar.visibility = View.GONE
            binding.errorContainer.visibility = View.GONE

        }

        viewModel.observeError(this) {
            binding.errorTextView.text = it
            binding.progressBar.visibility = View.GONE
            binding.textView2.visibility = View.INVISIBLE
            binding.textView3.visibility = View.INVISIBLE
            binding.errorContainer.visibility = View.VISIBLE
        }

        binding.tryAgainButton.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            viewModel.getCurrency()
        }

        viewModel.getCurrency()

    }


    private fun init() {
        binding.progressBar.visibility = View.VISIBLE
        binding.textView2.visibility = View.INVISIBLE
        binding.textView3.visibility = View.INVISIBLE
    }
}