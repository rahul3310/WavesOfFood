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
import com.wavesoffood.databinding.FragmentOrderHistoryBinding
import com.wavesoffood.datamodels.MenuItemDetails
import com.wavesoffood.utils.clicklistener.OnBuyAgainClickListener

class OrderHistoryFragment : Fragment() {
    private lateinit var binding: FragmentOrderHistoryBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_order_history, container, false)
        navController = (activity as MainActivity).findNavController(R.id.nav_host_fragment)
        //Menu item Recyclerview---->
        val menuItemsList = ArrayList<MenuItemDetails>()
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_2))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_3))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_4))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_1))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_2, isRecentBuy = true))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_3))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_4, isRecentBuy = true))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_4, isRecentBuy = true))
        menuItemsList.add(MenuItemDetails("Herbal Pancake", 35, R.drawable.menu_photo_4, isRecentBuy = true))
        val adapterRecentBuy = OrderHistoryRecyclerViewAdapter(menuItemsList = menuItemsList.filter { it.isRecentBuy })
        val adapterPreviousBuy = OrderHistoryRecyclerViewAdapter(menuItemsList = menuItemsList.filter { !it.isRecentBuy })
        binding.recyclerViewCartContainerPreviousBuy.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCartContainerPreviousBuy.adapter = adapterPreviousBuy


        binding.recyclerViewCartContainerRecentBuy.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCartContainerRecentBuy.adapter = adapterRecentBuy
        val onBuyAgainClickListener = object : OnBuyAgainClickListener {
            override fun onBuyAgainClicked(menuItem: MenuItemDetails) {
                val bundle = Bundle()
                bundle.putParcelable("menuItem", menuItem)
                navController.navigate(R.id.action_menuFragment_to_cartFragment,bundle)
            }
        }
        adapterPreviousBuy.setBuyAgainClickListener(onBuyAgainClickListener)

        return binding.root
    }

}