package com.ianpedraza.temperatureconversion.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TemperatureViewModel : ViewModel() {

    private val _result = MutableLiveData<Double>()

    private val _resultString = MutableLiveData<String>()
    val resultString: LiveData<String> = _resultString

    fun toFahrenheit(celsius: Double) {
        _result.value = (celsius * TO_FAHRENHEIT_CONSTANT) + 32
        _resultString.value =  String.format("%.2f °F", _result.value)
    }

    fun toCelsius(fahrenheit: Double) {
        _result.value = (fahrenheit - 32) * TO_CELSIUS_CONSTANT
        _resultString.value = String.format("%.2f °C", _result.value)
    }

    companion object {
        private const val TO_CELSIUS_CONSTANT = (5.0 / 9.0)
        private const val TO_FAHRENHEIT_CONSTANT = (9.0 / 5.0)
    }
}