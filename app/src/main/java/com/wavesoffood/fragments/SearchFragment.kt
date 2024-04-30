package com.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.wavesoffood.MainActivity
import com.wavesoffood.R
import com.wavesoffood.adapters.OrderHistoryRecyclerViewAdapter
import com.wavesoffood.databinding.FragmentSearchBinding
import com.wavesoffood.datamodels.MenuItemDetails
import com.wavesoffood.utils.ButtonClickCallBacks


class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_search, container, false)
        navController = (activity as MainActivity).findNavController(R.id.nav_host_fragment)
        //Menu item Recyclerview---->
        val menuItemsList = ArrayList<MenuItemDetails>()
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_2))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_3))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_4))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_2))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_3))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_4))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_2))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_3))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_4))
        val adapter = OrderHistoryRecyclerViewAdapter(menuItemsList = menuItemsList)
        binding.recyclerViewCartContainer.layoutManager =   LinearLayoutManager(requireContext())
        binding.recyclerViewCartContainer.adapter = adapter

        val addToCartClick = ButtonClickCallBacks{menuItem ->
            navController.navigate(R.id.action_searchFragment_to_addToCartFragment)
        }
        adapter.setAddToCartClickListener(addToCartClick)

        return binding.root
    }

}