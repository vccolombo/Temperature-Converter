package com.github.vccolombo.temperatureconverter.module

import com.github.vccolombo.temperatureconverter.model.ConverterRepository
import com.github.vccolombo.temperatureconverter.model.ConverterRepositoryImpl
import com.github.vccolombo.temperatureconverter.service.ConverterService
import com.github.vccolombo.temperatureconverter.service.ConverterServiceImpl
import com.github.vccolombo.temperatureconverter.ui.converter.fragment.ConverterViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModules = module {
    single {
        @Suppress("USELESS_CAST")
        ConverterServiceImpl() as ConverterService
    }
}

val repositoryModules = module {
    single {
        @Suppress("USELESS_CAST")
        ConverterRepositoryImpl(
            converterService = get()
        ) as ConverterRepository
    }
}

val viewModelModules = module {
    viewModel { ConverterViewModel(converterRepository = get()) }
}