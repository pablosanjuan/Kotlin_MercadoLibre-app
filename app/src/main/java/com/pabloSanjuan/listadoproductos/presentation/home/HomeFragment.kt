package com.pabloSanjuan.listadoproductos.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.pabloSanjuan.listadoproductos.databinding.FragmentHomeBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment
import com.pabloSanjuan.listadoproductos.presentation.home.items.ItemProduct
import com.pabloSanjuan.listadoproductos.utils.ktx.hideKeyboard
import com.pabloSanjuan.listadoproductos.utils.ktx.toast
import com.pabloSanjuan.listadoproductos.utils.ktx.visible
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import dagger.android.support.AndroidSupportInjection

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    private lateinit var viewModel: HomeViewModel
    val adapter = GroupAdapter<ViewHolder>()

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
//        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, object :
//            OnBackPressedCallback(true) {
//            override fun handleOnBackPressed() {
//            }
//        })
        binding.recyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = adapter
        if (viewModel.productsList.value != null) {
            itemsUIState(true)
        }
        initObservers()
        initListeners()
    }


    private fun itemsUIState(state: Boolean) {
        binding.searchButton.visible = state
        binding.recyclerView.visible = state
        binding.bienvenidoText.visible = state.not()
        binding.imageLottieArrow.visible = state.not()
        binding.imageLottieSearch.visible = state.not()
    }

    private fun initListeners() {
        binding.inputEditSearch.apply {
            setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    itemsUIState(true)
                }
            }
        }
        binding.searchButton.apply {
            setOnClickListener {
                binding.inputEditSearch.clearFocus()
                activity?.hideKeyboard(it)
                if (getInputText().isEmpty().not()) {
                    viewModel.getData(query = getInputText())
                    showLoading(true)
                } else {
                    context.toast("por favor introducir algo para buscar!")
                }
            }
        }
        with(binding.imageLottieSearch) {
            setAnimation("lottie_search.json")
            repeatCount = 1
            speed = 1f
            playAnimation()
        }
        with(binding.imageLottieArrow) {
            setAnimation("lottie_arrow.json")
            loop(true)
            speed = 1f
            playAnimation()
        }
    }

    private fun getInputText(): String {
        return binding.inputEditSearch.text.toString()
    }

    private fun initObservers() {
        viewModel.productsList.observe(viewLifecycleOwner, Observer {
            if (it.paging.total != 0) {
                adapter.clear()
                it?.results?.forEach { result ->
                    adapter.add(ItemProduct(result))
                }
            } else {
                binding.bienvenidoText.text = "0 Resultados"
                showNoResults()
            }
            showLoading(false)
        })
    }

    private fun showNoResults() {
        itemsUIState(false)
        with(binding.imageLottieSearch) {
            setAnimation("lottie_no_found.json")
            repeatCount = 3
            speed = 1f
            playAnimation()
        }
    }

    private fun showLoading(show: Boolean?) {
        binding.skeletonLoading.visibility = if (show == true) View.VISIBLE else View.GONE
    }
}