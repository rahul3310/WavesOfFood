package com.wavesoffood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wavesoffood.databinding.CustomMenuViewBinding
import com.wavesoffood.databinding.OrderHistoryCustomViewBinding
import com.wavesoffood.datamodels.MenuItemDetails
import com.wavesoffood.utils.ButtonClickCallBacks

class OrderHistoryRecyclerViewAdapter(
    private val menuItemsList: List<MenuItemDetails>
) : RecyclerView.Adapter<OrderHistoryRecyclerViewAdapter.MenuViewHolder>() {

    private var addToCartClickListener: ButtonClickCallBacks? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(OrderHistoryCustomViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return menuItemsList.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = menuItemsList[position]
        holder.bind(menuItem)
    }

    inner class MenuViewHolder(val binding: OrderHistoryCustomViewBinding) : RecyclerView.ViewHolder(binding.root) {
          fun bind(menuItemDetails: MenuItemDetails){
              binding.menuImage.setImageResource(menuItemDetails.itemImage)
              binding.dishName.text = menuItemDetails.itemName
              binding.itemPrice.text = menuItemDetails.itemPrice
              if (menuItemDetails.isRecentBuy){
                  binding.addToCartButton.visibility = View.GONE
                  binding.recentBuy.visibility = View.VISIBLE
              }else{
                  binding.addToCartButton.visibility = View.VISIBLE
                  binding.recentBuy.visibility = View.GONE
              }
              binding.addToCartButton.setOnClickListener {
                  addToCartClickListener?.onAddToCartClicked(menuItemDetails)

              }
          }

    }

    fun setAddToCartClickListener(listener: ButtonClickCallBacks) {
        addToCartClickListener = listener
    }

}