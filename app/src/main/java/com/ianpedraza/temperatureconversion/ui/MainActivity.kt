package com.ianpedraza.temperatureconversion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ianpedraza.temperatureconversion.databinding.ActivityMainBinding
import com.ianpedraza.temperatureconversion.utils.viewBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel: TemperatureViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnToCelsius.setOnClickListener {
            val value = getValue()
            viewModel.toCelsius(value)
        }

        binding.btnToFahrenheit.setOnClickListener {
            val value = getValue()
            viewModel.toFahrenheit(value)
        }

        viewModel.resultString.observe(this) { result ->
            result?.let {
                binding.tvResult.text = result
            }
        }
    }

    private fun getValue(): Double {
        return try {
            binding.tietTemperature.text.toString().toDouble()
        } catch (e: Exception) {
            0.0
        }
    }
}