package com.github.vccolombo.temperatureconverter.ui.converter.fragment

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.vccolombo.temperatureconverter.model.ConverterRepository
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber
import kotlin.coroutines.CoroutineContext

class ConverterViewModel(private val converterRepository: ConverterRepository) : ViewModel() {
    // Coroutine's background job
    private val job = Job()
    // Define default thread for Coroutine as Main and add job
    private val coroutineContext: CoroutineContext = Dispatchers.Default + job
    private val scope = CoroutineScope(coroutineContext)

    var fromUnit = MutableLiveData<Int>()
    var toUnit = MutableLiveData<Int>()
    var valueToConvert = MutableLiveData<String>()

    var conversionResult = MutableLiveData<String>()

    // TODO: Handle errors
    var showError = MutableLiveData<Boolean>()

    init {
        fromUnit.value = 1
        toUnit.value = 2
    }

    fun onInputChanged() {
        var from: String? = null
        var to: String? = null

        // TODO : Find a better way to handle this
        when (fromUnit.value) {
            0 -> from = "fahrenheit"
            1 -> from = "celsius"
            2 -> from = "kelvin"
        }
        when (toUnit.value) {
            0 -> to = "fahrenheit"
            1 -> to = "celsius"
            2 -> to = "kelvin"
        }

        var value: Double? = null
        try {
            value = valueToConvert.value?.toDouble()
        } catch (ex: Exception) {
            Timber.e(ex)
            showError.value = true
        }
        if (value != null && to != null && from != null) {
            convertTemperature(value, from, to)
        } else {
            showError.value = true
        }
    }

    private fun convertTemperature(value: Double, from: String, to: String) {
        Timber.d("Convert $value from $from to $to")
        showError.value = null
        scope.launch {
            val result = converterRepository.convert(value, from, to)
            conversionResult.postValue(result)
            Timber.d(result)
        }
    }
}