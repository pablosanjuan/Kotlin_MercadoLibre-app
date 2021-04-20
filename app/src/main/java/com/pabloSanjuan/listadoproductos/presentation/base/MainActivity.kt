package com.pabloSanjuan.listadoproductos.presentation.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.pabloSanjuan.listadoproductos.MainApplication.Companion.appComponent
import com.pabloSanjuan.listadoproductos.R
import com.pabloSanjuan.listadoproductos.databinding.ActivityMainBinding
import com.pabloSanjuan.listadoproductos.utils.ktx.setupWithNavController

class MainActivity : BaseActivity<MainActivityViewModel, ActivityMainBinding>(),
    NavController.OnDestinationChangedListener {

    private var currentNavController: NavController? = null
    private lateinit var navGraphIds: List<Int>

    companion object {
        var currentMenuId: Int =  R.id.search_navigation
        fun start(context: Context, bundle: Bundle? = null) {
            val intent = Intent(context, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            context.startActivity(intent, bundle)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigationBar()

        if (savedInstanceState != null) {
            binding.bottomNavigationMain.selectedItemId =
                currentMenuId
        }
    }

    private fun setupBottomNavigationBar() {
        navGraphIds = listOf(
            R.navigation.search_navigation,
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
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.navigateUp() ?: false
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        //Hacer Si es Necesario
    }
}