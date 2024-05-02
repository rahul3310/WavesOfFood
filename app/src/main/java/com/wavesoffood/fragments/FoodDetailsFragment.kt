package com.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.wavesoffood.MainActivity
import com.wavesoffood.R
import com.wavesoffood.databinding.FragmentAddToCartBinding
import com.wavesoffood.datamodels.MenuItemDetails

class FoodDetailsFragment : Fragment() {
    private lateinit var binding: FragmentAddToCartBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_to_cart, container, false)

        val menuItemDetails = arguments?.getParcelable<MenuItemDetails>("menuItem")
        arguments = null

        menuItemDetails?.itemImage?.let { binding.foodImage.setImageResource(it) }
        binding.foodName.text = menuItemDetails?.itemName
        navController = (activity as MainActivity).getNavController()
        binding.addToCartButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("menuItem", menuItemDetails)
            navController.navigate(R.id.action_foodDetailsFragment_to_cartFragment)
        }

        binding.backArrowImg.setOnClickListener {
            navController.popBackStack()
        }
        return binding.root
    }

}