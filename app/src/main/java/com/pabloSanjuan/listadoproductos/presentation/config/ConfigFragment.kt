package com.pabloSanjuan.listadoproductos.presentation.config

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.databinding.FragmentConfigBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment
import com.pabloSanjuan.listadoproductos.utils.ktx.toast

class ConfigFragment : BaseFragment<ConfigViewModel, FragmentConfigBinding>() {

    private lateinit var viewModel: ConfigViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentConfigBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = initViewModel()
         val ss = viewModel.getThemeIndex()
        setThemeUI(ss)
        initListeners()
        initObservers()
    }

    private fun initObservers() {
        viewModel.themeIndex.observe(viewLifecycleOwner, Observer {
            setThemeUI(it)
        })
    }

    private fun setThemeUI(themeIndex: Int) {
        clearThemeUI()
        with(requireContext().resources.getColor(R.color.lime_50)) {
            when (themeIndex) {
                -1 -> binding.themeSystem.setColorFilter(this)
                1 -> binding.themeLight.setColorFilter(this)
                2 -> binding.themeDark.setColorFilter(this)
                else -> binding.themeSystem.setColorFilter(this)
            }
        }
    }

    private fun clearThemeUI() {
        with(requireContext().resources.getColor(R.color.grey_600)) {
            binding.themeLight.setColorFilter(this)
            binding.themeSystem.setColorFilter(this)
            binding.themeDark.setColorFilter(this)
        }
    }

    private fun initListeners() {
        with(binding) {
            themeLight.apply {
                setOnClickListener {
                    viewModel.setThemeIndex(0)
                    requireContext().toast(context.getString(R.string.light_mode))
                }
            }
            themeSystem.apply {
                setOnClickListener {
                    viewModel.setThemeIndex(1)
                    requireContext().toast(context.getString(R.string.controlado_SO))
                }
            }
            themeDark.apply {
                setOnClickListener {
                    viewModel.setThemeIndex(2)
                    requireContext().toast(context.getString(R.string.dark_mode))
                }
            }
        }
    }
}
