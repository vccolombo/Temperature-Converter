package com.github.vccolombo.temperatureconverter.model

import com.github.vccolombo.temperatureconverter.service.ConverterService

interface ConverterRepository {
    suspend fun convert(value: Double, from: String, to: String): String
}

class ConverterRepositoryImpl(private val converterService: ConverterService) :
    ConverterRepository {
    override suspend fun convert(value: Double, from: String, to: String): String {
        var result: Double = value
        when (from) {
            "kelvin" -> {
                when (to) {
                    "fahrenheit" -> result = converterService.kelvinToFahrenheit(value)
                    "celsius" -> result = converterService.kelvinToCelsius(value)
                }
            }
            "celsius" -> {
                when (to) {
                    "kelvin" -> result = converterService.celsiusToKelvin(value)
                    "fahrenheit" -> {
                        val valueKelvin = converterService.celsiusToKelvin(value)
                        result = converterService.kelvinToFahrenheit(valueKelvin)
                    }
                }
            }
            "fahrenheit" -> {
                when (to) {
                    "kelvin" -> result = converterService.fahrenheitToKelvin(value)
                    "celsius" -> {
                        val valueKelvin = converterService.fahrenheitToKelvin(value)
                        result = converterService.kelvinToCelsius(valueKelvin)
                    }
                }
            }
        }

        return result.toString()
    }
}