package com.pabloSanjuan.listadoproductos.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.pabloSanjuan.listadoproductos.MainApplication
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.databinding.FragmentHomeBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseFragment
import com.pabloSanjuan.listadoproductos.presentation.home.items.ItemProduct
import com.pabloSanjuan.listadoproductos.utils.ktx.hideKeyboard
import com.pabloSanjuan.listadoproductos.utils.ktx.toast
import com.pabloSanjuan.listadoproductos.utils.ktx.visible
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    private lateinit var viewModel: HomeViewModel
    private val adapter = GroupAdapter<ViewHolder>()
    companion object{
        const val COLUMNS_NUMBER = 3
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        MainApplication.appComponent.inject(this)
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
        binding.recyclerView.let {
            it.layoutManager =
                GridLayoutManager(requireContext(), COLUMNS_NUMBER)
            it.adapter = adapter
        }
        if (viewModel.productsList.value != null) {
            itemsUIState(true)
        }
        initObservers()
        initListeners()
    }


    private fun itemsUIState(state: Boolean) {
        binding.let {
            it.searchButton.visible = state
            it.recyclerView.visible = state
            it.bienvenidoText.visible = state.not()
            it.imageLottieArrow.visible = state.not()
            it.imageLottieSearch.visible = state.not()
        }
    }

    private fun initListeners() {
        binding.let{
            it.inputEditSearch.apply {
                setOnFocusChangeListener { _, hasFocus ->
                    if (hasFocus) {
                        itemsUIState(true)
                    }
                }
            }
            it.searchButton.apply {
                setOnClickListener {
                    binding.inputEditSearch.clearFocus()
                    activity?.hideKeyboard(it)
                    if (getInputText().isEmpty().not()) {
                        viewModel.getData(query = getInputText())
                        showLoading(true)
                    } else {
                        context.toast(context.getString(R.string.palabra_a_buscar))
                    }
                }
            }
            it.imageLottieSearch.run {
                setAnimation("lottie_search.json")
                repeatCount = 1
                speed = 1f
                playAnimation()
            }
            it.imageLottieArrow.run {
                setAnimation("lottie_arrow.json")
                loop(true)
                speed = 1f
                playAnimation()
            }
        }
    }

    private fun getInputText(): String {
        return binding.inputEditSearch.text.toString()
    }

    private fun initObservers() {
        viewModel.productsList.observe(viewLifecycleOwner, Observer {
            if (it.paging?.total != 0) {
                adapter.clear()
                it?.results?.forEach { result ->
                    adapter.add(ItemProduct(result))
                }
            } else {
                adapter.clear()
                binding.bienvenidoText.text = requireContext().getString(R.string.palabra_a_buscar)
                showNoResults()
            }
            showLoading(false)
        })
    }

    private fun showNoResults() {
        itemsUIState(false)
        binding.imageLottieSearch.let {
            it.setAnimation("lottie_no_found.json")
            it.repeatCount = 3
            it.speed = 1f
            it.playAnimation()
        }
    }

    private fun showLoading(show: Boolean?) {
        binding.skeletonLoading.visibility = if (show == true) View.VISIBLE else View.GONE
    }
}