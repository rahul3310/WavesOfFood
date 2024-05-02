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
import com.wavesoffood.databinding.CustomAapBarBinding

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

        if (BuildConfig.BUILD_IDENTIFIER == "admin") {
            binding.bottomNavigation.visibility = View.GONE
            binding.appBar.usertoolBarView.visibility = View.GONE
            binding.appBar.adminToolBarView.visibility = View.VISIBLE
            adminTopBarTitle(navController, binding.appBar)
        } else {
            bottomNavigationViewVisibility(navController, binding.bottomNavigation)
        }
        topBarVisibility(navController, binding.appBar.toolbar)


        binding.appBar.adminBackArrowImg.setOnClickListener {
            navController.popBackStack()
        }

        binding.appBar.userBackArrowImg.setOnClickListener {
            navController.popBackStack()
        }

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


    private fun adminTopBarTitle(
        navController: NavController,
        appBar: CustomAapBarBinding
    ) {
        navController.addOnDestinationChangedListener { _, destination, _ ->
             when (destination.id) {
                 R.id.adminHomeFragment->{
                     appBar.adminTopBarTitle.text = getString(R.string.app_name)
                     appBar.appLogoImage.visibility = View.VISIBLE
                     appBar.adminBackArrowImg.visibility = View.GONE
                 }
                 R.id.addItemFragment->{
                     appBar.adminTopBarTitle.text = getString(R.string.add_item)
                     appBar.appLogoImage.visibility = View.GONE
                     appBar.adminBackArrowImg.visibility = View.VISIBLE
                 }
                 R.id.allItemsFragment->{
                     appBar.adminTopBarTitle.text = getString(R.string.all_item)
                     appBar.appLogoImage.visibility = View.GONE
                     appBar.adminBackArrowImg.visibility = View.VISIBLE
                 }
                 R.id.outOfDeliveryFragment->{
                     appBar.adminTopBarTitle.text = getString(R.string.out_of_delivery)
                     appBar.appLogoImage.visibility = View.GONE
                     appBar.adminBackArrowImg.visibility = View.VISIBLE
                 }
                 R.id.pendingOrdersFragment->{
                     appBar.adminTopBarTitle.text = getString(R.string.pending_orders)
                     appBar.appLogoImage.visibility = View.GONE
                     appBar.adminBackArrowImg.visibility = View.VISIBLE
                 }
                 R.id.profileFragment->{
                     appBar.adminTopBarTitle.text = getString(R.string.admin_profile)
                     appBar.appLogoImage.visibility = View.GONE
                     appBar.adminBackArrowImg.visibility = View.VISIBLE
                 }
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
                R.id.foodDetailsFragment -> View.GONE
                R.id.placeMyOrderFragment -> View.GONE
                else -> View.VISIBLE
            }
        }
    }

    fun getNavController() = navController
}
