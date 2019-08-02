package com.github.vccolombo.temperatureconverter.ui.converter

import androidx.lifecycle.ViewModel
import com.github.vccolombo.temperatureconverter.ConverterRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ConverterViewModel(private val converterRepository: ConverterRepository) : ViewModel() {
    // Coroutine's background job
    private val job = Job()
    // Define default thread for Coroutine as Main and add job
    private val coroutineContext: CoroutineContext = Dispatchers.Default + job
    private val scope = CoroutineScope(coroutineContext)

    fun convertTemperature(value: String, from: String, to: String) {
        scope.launch {
            converterRepository.convert(value.toFloat(), from, to)
        }
    }
}
