package com.github.vccolombo.temperatureconverter.ui.converter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.vccolombo.temperatureconverter.R
import com.github.vccolombo.temperatureconverter.ui.converter.fragment.ConverterFragment

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
