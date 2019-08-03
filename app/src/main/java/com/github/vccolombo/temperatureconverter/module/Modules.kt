package com.github.vccolombo.temperatureconverter.module

import com.github.vccolombo.temperatureconverter.model.ConverterRepository
import com.github.vccolombo.temperatureconverter.model.ConverterRepositoryImpl
import com.github.vccolombo.temperatureconverter.service.ConverterService
import com.github.vccolombo.temperatureconverter.service.ConverterServiceImpl
import com.github.vccolombo.temperatureconverter.ui.converter.fragment.ConverterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModules = module {
    factory<ConverterService> { ConverterServiceImpl() }
}

val repositoryModules = module {
    factory<ConverterRepository> {
        ConverterRepositoryImpl(
            converterService = get()
        )
    }
}

val viewModelModules = module {
    viewModel { ConverterViewModel(converterRepository = get()) }
}