package com.pabloSanjuan.listadoproductos.presentation.config

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.databinding.FragmentConfigBinding
import com.pabloSanjuan.listadoproductos.databinding.FragmentDetailsBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment
import com.pabloSanjuan.listadoproductos.presentation.details.DetailsViewModel
import dagger.android.support.AndroidSupportInjection

class ConfigFragment : BaseFragment<ConfigViewModel, FragmentConfigBinding>() {

    private lateinit var viewModel: ConfigViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
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
