package com.wavesoffood.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wavesoffood.R
import com.wavesoffood.databinding.AllItemCustomViewBinding
import com.wavesoffood.datamodels.MenuItemDetails

class AllItemsAdapter(
    private val itemList: ArrayList<MenuItemDetails>
) : RecyclerView.Adapter<AllItemsAdapter.AllItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemViewHolder {
        return AllItemViewHolder(
            AllItemCustomViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    override fun onBindViewHolder(holder: AllItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }
    inner class AllItemViewHolder(val binding: AllItemCustomViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemDetails: MenuItemDetails) {
            binding.menuImage.setImageResource(itemDetails.itemImage)
            binding.dishName.text = itemDetails.itemName
            binding.itemPrice.text = "$ ${itemDetails.itemPrice}"
            binding.orderCountButtons.orderCount.text = itemDetails.quantity.toString()
            binding.itemView.setOnClickListener {
                // onItemClickListener?.onItemClick(itemDetails)
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
            if ( itemList[position].quantity<10) {
                val priceOfOneItem =
                    itemList[position].itemPrice / itemList[position].quantity
                itemList[position].quantity += 1
                itemList[position].itemPrice = priceOfOneItem * itemList[position].quantity
                binding.orderCountButtons.orderCount.text = itemList[position].quantity.toString()
                notifyItemChanged(position)
                notifyItemRangeChanged(position, itemList.size)
            }
        }

        private fun minusItemCount(position: Int) {
            if (itemList[position].quantity > 1) {
                val priceOfOneItem =  itemList[position].itemPrice/itemList[position].quantity
                itemList[position].quantity -= 1
                itemList[position].itemPrice = priceOfOneItem * itemList[position].quantity
                binding.orderCountButtons.orderCount.text = itemList[position].quantity.toString()
                notifyItemChanged(position)
                notifyItemRangeChanged(position, itemList.size)
            }
        }

        private fun deleteItem(position : Int){
            itemList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemChanged(position)
            notifyItemRangeChanged(position,itemList.size)
        }

    }


}