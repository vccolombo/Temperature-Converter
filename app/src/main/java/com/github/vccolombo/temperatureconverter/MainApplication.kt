package com.github.vccolombo.temperatureconverter

import android.app.Application
import com.github.vccolombo.temperatureconverter.module.repositoryModules
import com.github.vccolombo.temperatureconverter.module.serviceModules
import com.github.vccolombo.temperatureconverter.module.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(listOf(serviceModules, viewModelModules, repositoryModules))
        }
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}