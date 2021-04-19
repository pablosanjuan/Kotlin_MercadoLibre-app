package com.pabloSanjuan.listadoproductos.presentation

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.databinding.ActivityMainBinding
import com.pabloSanjuan.listadoproductos.presentation.base.BaseActivity

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>() {

    private lateinit var viewModel: MainActivityViewModel
    private var currentNavController: NavController? = null
    private lateinit var navGraphIds: List<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = initViewModel()
        viewModel.getData()
        initObservers()
        //setupBottomNavigationBar()
    }

    private fun initObservers(){
        viewModel.productsList.observe(this, Observer {
            val listResult = it
        })
    }

/*    private fun setupBottomNavigationBar() {
        navGraphIds = listOf(
            R.navigation.home_navigation,
            R.navigation.config_navigation
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = binding.bottomNavigationMain.setupWithNavController(
            navGraphIds,
            supportFragmentManager,
            R.id.fragment_main_host
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(
            this
        ) { navController ->
            // setupActionBarWithNavController(navController)
            currentNavController?.removeOnDestinationChangedListener(this)
            currentNavController = navController
            currentNavController?.addOnDestinationChangedListener(this)
            currentMenuId = navController.graph.id
        }
    }*/

}