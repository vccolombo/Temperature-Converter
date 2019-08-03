package com.github.vccolombo.temperatureconverter.ui.converter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.vccolombo.temperatureconverter.databinding.ConverterFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Better UI

class ConverterFragment : Fragment() {

    companion object {
        fun newInstance() = ConverterFragment()
    }

    private val viewModel by viewModel<ConverterViewModel>()

    private lateinit var binding: ConverterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ConverterFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
