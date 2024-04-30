package com.wavesoffood.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.wavesoffood.R
import com.wavesoffood.databinding.CustomCartViewBinding
import com.wavesoffood.datamodels.MenuItemDetails
import com.wavesoffood.utils.ButtonClickCallBacks

class CartRecyclerViewAdapter(
    private val menuItemsList: ArrayList<MenuItemDetails>
) : RecyclerView.Adapter<CartRecyclerViewAdapter.MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            CustomCartViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return menuItemsList.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val menuItem = menuItemsList[position]
        holder.bind(menuItem)
    }

    inner class MenuViewHolder(val binding: CustomCartViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(menuItemDetails: MenuItemDetails) {
            binding.menuImage.setImageResource(menuItemDetails.itemImage)
            binding.dishName.text = menuItemDetails.itemName
            binding.itemPrice.text = menuItemDetails.itemPrice
            binding.orderCountButtons.orderCount.text = menuItemDetails.quantity.toString()

            binding.orderCountButtons.plusButton.setOnClickListener{
                plusItemCount(adapterPosition)
            }
            binding.orderCountButtons.minusButton.setOnClickListener{
                minusItemCount(adapterPosition)
            }
            binding.deleteOrder.setOnClickListener{
                deleteItem(adapterPosition)
            }

            binding
        }
        private fun plusItemCount(position : Int){
            if (menuItemsList[position].quantity<=10) {
                menuItemsList[position].quantity += 1
                binding.orderCountButtons.orderCount.text =  menuItemsList[position].quantity.toString()
            }
        }
        private fun minusItemCount(position : Int){
            if (menuItemsList[position].quantity>1) {
                menuItemsList[position].quantity -= 1
                binding.orderCountButtons.orderCount.text =  menuItemsList[position].quantity.toString()
            }
        }
        private fun deleteItem(position : Int){
            menuItemsList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemChanged(position)
            notifyItemRangeChanged(position,menuItemsList.size)
        }
    }



}