package com.github.vccolombo.temperatureconverter

interface ConverterService {
    suspend fun celsiusToKelvin(celsius: Float) : Float
    suspend fun kelvinToCelsius(kelvin: Float) : Float
    suspend fun fahrenheitToKelvin(fahrenheit: Float) : Float
    suspend fun kelvinToFahrenheit(kelvin: Float) : Float
}

class ConverterServiceImpl: ConverterService {
    override suspend fun fahrenheitToKelvin(fahrenheit: Float): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun kelvinToFahrenheit(kelvin: Float): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun celsiusToKelvin(celsius: Float): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun kelvinToCelsius(kelvin: Float): Float {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
