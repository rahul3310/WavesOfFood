package com.wavesoffood.adminfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.wavesoffood.R
import com.wavesoffood.adapters.AllItemsAdapter
import com.wavesoffood.adapters.MenuAdapter
import com.wavesoffood.databinding.FragmentAllItemsBinding
import com.wavesoffood.datamodels.MenuItemDetails

class AllItemsFragment : Fragment() {
    private lateinit var binding: FragmentAllItemsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_all_items, container, false)

        //Menu item Recyclerview---->
        val menuItemsList = ArrayList<MenuItemDetails>()
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_1, restaurantName = "Waroenk kita"))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_2, restaurantName = "Waroenk kita"))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_3, restaurantName = "Waroenk kita"))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_1, restaurantName = "Waroenk kita"))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_2, restaurantName = "Waroenk kita"))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_3, restaurantName = "Waroenk kita"))
        val adapter = AllItemsAdapter(itemList = menuItemsList)
        binding.addItemRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.addItemRecyclerView.adapter = adapter


        return binding.root
    }

}