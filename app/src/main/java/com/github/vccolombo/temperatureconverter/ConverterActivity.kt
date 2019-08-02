package com.github.vccolombo.temperatureconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.vccolombo.temperatureconverter.ui.converter.ConverterFragment

class ConverterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.converter_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ConverterFragment.newInstance())
                .commitNow()
        }
    }

}
