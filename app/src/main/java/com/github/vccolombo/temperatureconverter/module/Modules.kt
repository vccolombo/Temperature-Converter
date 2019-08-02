package com.github.vccolombo.temperatureconverter.module

import com.github.vccolombo.temperatureconverter.ConverterRepository
import com.github.vccolombo.temperatureconverter.ConverterRepositoryImpl
import com.github.vccolombo.temperatureconverter.ConverterService
import com.github.vccolombo.temperatureconverter.ConverterServiceImpl
import com.github.vccolombo.temperatureconverter.ui.converter.ConverterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModules = module {
    factory<ConverterService> { ConverterServiceImpl() }
}

val repositoryModules = module {
    factory<ConverterRepository> { ConverterRepositoryImpl(converterService = get()) }
}

val viewModelModules = module {
    viewModel { ConverterViewModel(converterRepository = get()) }
}