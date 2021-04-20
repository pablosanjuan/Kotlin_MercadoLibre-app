package com.pabloSanjuan.listadoproductos.presentation.config

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabloSanjuan.listadoproductos.MainApplication
import com.pabloSanjuan.listadoproductos.databinding.FragmentConfigBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment

class ConfigFragment : BaseFragment<ConfigViewModel, FragmentConfigBinding>() {

    private lateinit var viewModel: ConfigViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApplication.appComponent.inject(this)
    }

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
    }

    companion object {
    }
}
