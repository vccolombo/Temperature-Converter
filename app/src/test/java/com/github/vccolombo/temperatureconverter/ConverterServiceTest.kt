package com.github.vccolombo.temperatureconverter

import com.github.vccolombo.temperatureconverter.module.serviceModules
import com.github.vccolombo.temperatureconverter.service.ConverterService
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject


class ConverterServiceTest: KoinTest {
    private val service by inject<ConverterService>()

    @Before
    fun before() {
        startKoin {
            modules(serviceModules)
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun convert20fahrenheitToKelvin() {
        val expected = 266.483
        val result = runBlocking { service.fahrenheitToKelvin(20.0) }
        assertEquals(expected, result, .01)
    }

    @Test
    fun convert0fahrenheitToKelvin() {
        val expected = 255.372
        val result = runBlocking { service.fahrenheitToKelvin(0.0) }
        assertEquals(expected, result, .01)
    }

    @Test
    fun convert0KelvinToFahrenheit() {
        val expected = -459.67
        val result = runBlocking { service.kelvinToFahrenheit(0.0) }
        assertEquals(expected, result, .01)
    }

    @Test
    fun convert273KelvinToFahrenheit() {
        val expected = 31.73
        val result = runBlocking { service.kelvinToFahrenheit(273.0) }
        assertEquals(expected, result, .01)
    }

    @Test
    fun convert0CelsiusToKelvin() {
        val expected = 273.15
        val result = runBlocking { service.celsiusToKelvin(0.0) }
        assertEquals(expected, result, .01)
    }

    @Test
    fun convertMinus10CelsiusToKelvin() {
        val expected = 263.15
        val result = runBlocking { service.celsiusToKelvin(-10.0) }
        assertEquals(expected, result, .01)
    }

    @Test
    fun convert0KelvinToCelsius() {
        val expected = -273.15
        val result = runBlocking { service.kelvinToCelsius(0.0) }
        assertEquals(expected, result, .01)
    }

    @Test
    fun convert373KelvinToCelsius() {
        val expected = 99.85
        val result = runBlocking { service.kelvinToCelsius(373.0) }
        assertEquals(expected, result, .01)
    }
}
