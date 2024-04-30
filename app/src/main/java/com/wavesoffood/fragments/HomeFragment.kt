package com.wavesoffood.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.models.SlideModel
import com.wavesoffood.MainActivity
import com.wavesoffood.R
import com.wavesoffood.adapters.MenuAdapter
import com.wavesoffood.databinding.FragmentHomeBinding
import com.wavesoffood.datamodels.MenuItemDetails
import com.wavesoffood.utils.clicklistener.OnAddToCartClickListener
import com.wavesoffood.utils.clicklistener.OnItemClickListener


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1))
        imageList.add(SlideModel(R.drawable.banner1))
        imageList.add(SlideModel(R.drawable.banner1))
        imageList.add(SlideModel(R.drawable.banner1))

        binding.imageSlider.setImageList(imageList) //centerCrop for all images
        binding.imageSlider.startSliding(3000)

        //Menu item Recyclerview---->
        val menuItemsList = ArrayList<MenuItemDetails>()
        menuItemsList.add(MenuItemDetails("Herbal Pancake", "$ 35", R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", "$ 35", R.drawable.menu_photo_2))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", "$ 35", R.drawable.menu_photo_3))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", "$ 35", R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", "$ 35", R.drawable.menu_photo_2))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", "$ 35", R.drawable.menu_photo_3))
        val adapter = MenuAdapter(menuItemsList = menuItemsList)
        binding.recyclerViewMenuContainer.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewMenuContainer.adapter = adapter


        val addToCartClick = object : OnAddToCartClickListener {
            override fun onAddToCartClicked(menuItem: MenuItemDetails) {
                (activity as MainActivity).getNavController()
                    .navigate(R.id.action_homeFragment_to_cartFragment)
            }

        }
        val onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(menuItemDetails: MenuItemDetails) {
                (activity as MainActivity).getNavController()
                    .navigate(R.id.action_homeFragment_to_foodDetailsFragment)
            }
        }
        adapter.setOnAddToCartListener(addToCartClick)
        adapter.setOnItemClickListener(onItemClickListener)
        return binding.root
    }

}