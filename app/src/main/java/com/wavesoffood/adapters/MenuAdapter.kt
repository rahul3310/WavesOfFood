package com.wavesoffood.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.wavesoffood.databinding.CustomMenuViewBinding
import com.wavesoffood.datamodels.MenuItemDetails
import com.wavesoffood.utils.clicklistener.OnAddToCartClickListener
import com.wavesoffood.utils.clicklistener.OnItemClickListener

class MenuAdapter(
    private val menuItemsList: List<MenuItemDetails>
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private var addToCartClickedListener: OnAddToCartClickListener? = null
    private var onItemClickListener: OnItemClickListener? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            CustomMenuViewBinding.inflate(
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

    inner class MenuViewHolder(val binding: CustomMenuViewBinding) : ViewHolder(binding.root) {
        fun bind(menuItemDetails: MenuItemDetails) {
            binding.menuImage.setImageResource(menuItemDetails.itemImage)
            binding.dishName.text = menuItemDetails.itemName
            binding.itemPrice.text = menuItemDetails.itemPrice
            binding.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(menuItemDetails)
            }

            binding.addToCartButton.setOnClickListener {
                addToCartClickedListener?.onAddToCartClicked(menuItemDetails)
            }
        }
    }

    fun setOnAddToCartListener(listener: OnAddToCartClickListener) {
        addToCartClickedListener = listener
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        onItemClickListener = listener
    }

}