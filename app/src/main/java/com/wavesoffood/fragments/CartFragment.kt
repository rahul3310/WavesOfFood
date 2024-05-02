package com.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.wavesoffood.MainActivity
import com.wavesoffood.R
import com.wavesoffood.adapters.CartRecyclerViewAdapter
import com.wavesoffood.databinding.FragmentCartBinding
import com.wavesoffood.datamodels.MenuItemDetails
import com.wavesoffood.utils.clicklistener.OnItemClickListener

class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private val menuItemsList = ArrayList<MenuItemDetails>()
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        navController = (activity as MainActivity).getNavController()
        //Cart item Recyclerview---->
        val menuItem = arguments?.getParcelable<MenuItemDetails>("menuItem")
        arguments = null
        if (menuItem != null) {
            menuItemsList.clear()
            menuItemsList.add(menuItem)
        }

        if (menuItemsList.isEmpty()) {
            binding.cartItemStateTextView.visibility = View.VISIBLE
            binding.proceedButton.visibility = View.GONE
        } else {
            binding.cartItemStateTextView.visibility = View.GONE
            binding.proceedButton.visibility = View.VISIBLE
        }


        binding.proceedButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("totalPrice", getTotalPrice(menuItemsList))
            navController.navigate(R.id.action_cartFragment_to_placeMyOrderFragment,bundle)
        }

        val adapter = CartRecyclerViewAdapter(menuItemsList = menuItemsList)
        binding.recyclerViewCartContainer.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewCartContainer.adapter = adapter
        val onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(menuItemDetails: MenuItemDetails) {
                navController.navigate(R.id.action_cartFragment_to_foodDetailsFragment)
            }
        }
        adapter.setOnItemClickListener(onItemClickListener)
        return binding.root
    }

    private fun getTotalPrice(menuList: ArrayList<MenuItemDetails>): Int {
        return menuList.sumOf { it.itemPrice }
    }

}