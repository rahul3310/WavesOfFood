package com.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.wavesoffood.R
import com.wavesoffood.adapters.CartRecyclerViewAdapter
import com.wavesoffood.databinding.FragmentCartBinding
import com.wavesoffood.datamodels.MenuItemDetails

class CartFragment : Fragment() {
 private lateinit var binding: FragmentCartBinding
    private val menuItemsList = ArrayList<MenuItemDetails>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_cart, container, false)

        //Cart item Recyclerview---->

        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_2))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_3))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_4))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_2))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_3))
        menuItemsList.add(MenuItemDetails("Herbal Pancake","$ 35",R.drawable.menu_photo_4))

        val adapter = CartRecyclerViewAdapter(menuItemsList = menuItemsList)
        binding.recyclerViewCartContainer.layoutManager =   LinearLayoutManager(requireContext())
        binding.recyclerViewCartContainer.adapter = adapter


        return binding.root
    }


}