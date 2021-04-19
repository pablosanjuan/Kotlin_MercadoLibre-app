package com.pabloSanjuan.listadoproductos.presentation.splash

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pabloSanjuan.listadoproductos.databinding.FragmentSplashBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment
import dagger.android.support.AndroidSupportInjection

class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {

        private lateinit var viewModel: SplashViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = initViewModel()
    }

    companion object {
    }
}