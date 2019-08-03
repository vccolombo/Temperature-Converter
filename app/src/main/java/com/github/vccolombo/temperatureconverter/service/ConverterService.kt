package com.github.vccolombo.temperatureconverter.service

interface ConverterService {
    suspend fun celsiusToKelvin(celsius: Double) : Double
    suspend fun kelvinToCelsius(kelvin: Double) : Double
    suspend fun fahrenheitToKelvin(fahrenheit: Double) : Double
    suspend fun kelvinToFahrenheit(kelvin: Double) : Double
}

class ConverterServiceImpl: ConverterService {
    override suspend fun fahrenheitToKelvin(fahrenheit: Double): Double {
        return 5.0/9.0 * (fahrenheit - 32) + 273
    }

    override suspend fun kelvinToFahrenheit(kelvin: Double): Double {
        return 9.0/5.0 * (kelvin - 273) + 32
    }

    override suspend fun celsiusToKelvin(celsius: Double): Double {
        return celsius + 273
    }

    override suspend fun kelvinToCelsius(kelvin: Double): Double {
        return kelvin - 273
    }

}
