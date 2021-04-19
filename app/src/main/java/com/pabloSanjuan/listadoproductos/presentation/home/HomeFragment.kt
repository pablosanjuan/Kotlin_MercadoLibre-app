package com.pabloSanjuan.listadoproductos.presentation.home

import android.content.Context
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.activity.OnBackPressedCallback
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.pabloSanjuan.listadoproductos.databinding.FragmentHomeBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment
import dagger.android.support.AndroidSupportInjection

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    private lateinit var viewModel: HomeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = initViewModel()
        viewModel.getData()
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                with(binding.inputEditSearch){
                    if (isFocused)
                        clearFocus()
                }
                requireActivity().onBackPressed()
            }
        })
        initObservers()
        initListeners()
    }

    private fun initListeners() {
        binding.inputEditSearch.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                val params = binding.inputSearch.layoutParams as ConstraintLayout.LayoutParams
                params.bottomToBottom = binding.root.id
                binding.inputSearch.requestLayout()
            }
        }
    }

    private fun initObservers() {
        viewModel.productsList.observe(viewLifecycleOwner, Observer {
            val listResult = it
            //binding.foto
            //Glide.with(this)
            //    .load(it[0].thumbnail)
            //    .into(binding.foto)
            //binding.titulo.text = it[0].title
        })
    }
    companion object {
    }
}