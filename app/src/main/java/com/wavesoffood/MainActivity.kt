package com.wavesoffood

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wavesoffood.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = findNavController(R.id.nav_host_fragment)
        binding.bottomNavigation.setupWithNavController(navController)

        topBarVisibility(navController, binding.appBar.toolbar)
        bottomNavigationViewVisibility(navController, binding.bottomNavigation)
    }

    private fun topBarVisibility(
        navController: NavController,
        toolbar: androidx.appcompat.widget.Toolbar
    ) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            toolbar.visibility = when (destination.id) {
                R.id.loginFragment -> View.GONE
                R.id.chooseYourLocationFragment -> View.GONE
                R.id.signUpFragment -> View.GONE
                R.id.foodDetailsFragment -> View.GONE
                R.id.placeMyOrderFragment -> View.GONE
                else -> View.VISIBLE
            }
        }
    }

    private fun bottomNavigationViewVisibility(
        navController: NavController,
        bottomNavigationView: BottomNavigationView
    ) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            bottomNavigationView.visibility = when (destination.id) {
                R.id.loginFragment -> View.GONE
                R.id.chooseYourLocationFragment -> View.GONE
                R.id.signUpFragment -> View.GONE
                else -> View.VISIBLE
            }
        }
    }
    fun getNavController() = navController
}
