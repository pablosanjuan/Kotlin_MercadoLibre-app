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
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
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
        binding.recyclerSearchBooks.layoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.recyclerSearchBooks.adapter = adapter
        if (viewModel.productsList.value!=null){
            removeUI()
        }
        initObservers()
        initListeners()
    }

    private fun removeUI() {
        binding.searchButton.visible = true
        binding.bienvenidoText.visible = false
        binding.imageLottieArrow.visible = false
        binding.imageLottieSearch.visible = false
    }

    private fun initListeners() {
        binding.inputEditSearch.apply {
            setOnFocusChangeListener { _, hasFocus ->
                if (hasFocus) {
                    val params = binding.inputSearch.layoutParams as ConstraintLayout.LayoutParams
                    params.bottomToBottom = binding.root.id
                    binding.inputSearch.requestLayout()
                    removeUI()
                }
            }
        }
        binding.searchButton.apply {
            setOnClickListener {
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
            showLoading(false)
            adapter.clear()
            it?.forEach { result ->
                adapter.add(ItemProduct(result))
            }
        })
    }

    private fun showLoading(show: Boolean?) {
        binding.skeletonLoading.visibility = if (show == true) View.VISIBLE else View.GONE
    }
}