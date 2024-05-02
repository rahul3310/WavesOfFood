package com.wavesoffood.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wavesoffood.databinding.CustomCartViewBinding
import com.wavesoffood.datamodels.MenuItemDetails
import com.wavesoffood.utils.clicklistener.OnItemClickListener

class CartRecyclerViewAdapter(
    private val menuItemsList: ArrayList<MenuItemDetails>
) : RecyclerView.Adapter<CartRecyclerViewAdapter.MenuViewHolder>() {
 private var onItemClickListener : OnItemClickListener? = null
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
            binding.itemPrice.text = "$ ${menuItemDetails.itemPrice}"
            binding.orderCountButtons.orderCount.text = menuItemDetails.quantity.toString()
            binding.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(menuItemDetails)
            }

            binding.orderCountButtons.plusButton.setOnClickListener{
                plusItemCount(adapterPosition)
            }
            binding.orderCountButtons.minusButton.setOnClickListener{
                minusItemCount(adapterPosition)
            }
            binding.deleteOrder.setOnClickListener{
                deleteItem(adapterPosition)
            }

        }
        private fun plusItemCount(position: Int) {
            if ( menuItemsList[position].quantity<10) {
                val priceOfOneItem =
                    menuItemsList[position].itemPrice / menuItemsList[position].quantity
                menuItemsList[position].quantity += 1
                menuItemsList[position].itemPrice = priceOfOneItem * menuItemsList[position].quantity
                binding.orderCountButtons.orderCount.text =
                    menuItemsList[position].quantity.toString()
                notifyItemChanged(position)
                notifyItemRangeChanged(position, menuItemsList.size)
            }
        }

        private fun minusItemCount(position: Int) {
            if (menuItemsList[position].quantity > 1) {
                val priceOfOneItem =  menuItemsList[position].itemPrice/menuItemsList[position].quantity
                menuItemsList[position].quantity -= 1
                menuItemsList[position].itemPrice = priceOfOneItem * menuItemsList[position].quantity
                binding.orderCountButtons.orderCount.text = menuItemsList[position].quantity.toString()
                notifyItemChanged(position)
                notifyItemRangeChanged(position, menuItemsList.size)
            }
        }

        private fun deleteItem(position : Int){
            menuItemsList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemChanged(position)
            notifyItemRangeChanged(position,menuItemsList.size)
        }


    }
    fun setOnItemClickListener(listener: OnItemClickListener){
        onItemClickListener = listener
    }


}