package com.pabloSanjuan.listadoproductos.presentation.home

import android.animation.ValueAnimator
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
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
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Pablo Sanjuan
 *
 * Contiene la logica de la funcionalidad principal de la APP
 *
 * - hago uso de MVVM para mantener las instancias de los resusltados al girar pantalla
 * - uso libreria GROUPIE para instanciar el adapter del recyclerView
 * - contiene la logica para mostrar errores al usuario
 * - cotiene logica para mostrar los resultados al usuario
 * - permite al usuario navegar por los resultados
 *
 */

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    private lateinit var viewModel: HomeViewModel
    private val adapter = GroupAdapter<ViewHolder>()

    companion object {
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
            it.messagesText.visible = state.not()
            it.imageLottieArrow.visible = state.not()
            it.imageLottieSearch.visible = state.not()
        }
    }

    private fun initListeners() {
        binding.let {
            it.inputEditSearch.apply {
                setOnFocusChangeListener { _, hasFocus ->
                    if (hasFocus) {
                        itemsUIState(true)
                    }
                }
            }
            it.inputEditSearch.setOnEditorActionListener { _, p1, _ ->
                if (p1 == EditorInfo.IME_ACTION_SEARCH){
                    binding.inputEditSearch.clearFocus()
                    doSearch(input_edit_search)
                }
                true
            }
            it.searchButton.apply {
                setOnClickListener { view ->
                    binding.inputEditSearch.clearFocus()
                    doSearch(view)
                }
            }
            it.imageLottieSearch.run {
                setAnimation("lottie_hello.json")
                repeatCount = ValueAnimator.INFINITE
                speed = 1f
                playAnimation()
            }
            it.imageLottieArrow.run {
                setAnimation("lottie_arrow.json")
                repeatCount = ValueAnimator.INFINITE
                speed = 1f
                playAnimation()
            }
        }
    }

    private fun doSearch(view: View = View(requireContext())) {
        activity?.hideKeyboard(view)
        if (getInputText().isEmpty().not()) {
            adapter.clear()
            context?.let { context ->
                val isOnline = isNetworkOnline(context)
                viewModel.getData(
                    query = getInputText(),
                    isInternetAvailable = isOnline
                )
            }
            showLoading(true)
        } else {
            context?.let {
                it.toast(it.getString(R.string.palabra_a_buscar))
            }
        }
    }

    private fun getInputText(): String {
        return binding.inputEditSearch.text.toString()
    }

    private fun initObservers() {
        viewModel.apply {
            productsList.observe(viewLifecycleOwner, Observer {
                if (it.paging?.total != 0) {
                    adapter.clear()
                    itemsUIState(true)
                    it?.results?.forEach { result ->
                        adapter.add(ItemProduct(result))
                    }
                } else {
                    adapter.clear()
                    showUIError(requireContext().getString(R.string.no_results))
                }
                showLoading(false)
            })
            noInternetLiveData.observe(viewLifecycleOwner, Observer {
                showUIError(it)
            })
            serverIssueLiveData.observe(viewLifecycleOwner, Observer {
                showUILog(it)
            })
        }
    }

    private fun showUILog(msg: String) {
        context?.let {
            it.toast(msg)
        }
    }

    private fun showUIError(msg: String) {
        itemsUIState(false)
        binding.messagesText.text = msg
        showLoading(false)
        binding.imageLottieSearch.let {
            it.setAnimation("lottie_search.json")
            it.repeatCount = 3
            it.speed = 1f
            it.playAnimation()
        }
    }

    private fun showLoading(show: Boolean?) {
        binding.skeletonLoading.visibility = if (show == true) View.VISIBLE else View.GONE
    }
}