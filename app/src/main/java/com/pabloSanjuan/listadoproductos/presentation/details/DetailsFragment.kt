package com.pabloSanjuan.listadoproductos.presentation.details

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabloSanjuan.listadoproductos.databinding.FragmentDetailsBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment
import dagger.android.support.AndroidSupportInjection

class DetailsFragment : BaseFragment<DetailsViewModel, FragmentDetailsBinding>() {

    private lateinit var viewModel: DetailsViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = initViewModel()
    }

    companion object {
    }
}