package com.wavesoffood.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.wavesoffood.R
import com.wavesoffood.databinding.OrderDetailsViewBinding
import com.wavesoffood.datamodels.OrderDetails

class OrderDetailsAdapter(
    private val orderDetailsList: ArrayList<OrderDetails>
) : RecyclerView.Adapter<OrderDetailsAdapter.OrderDetailViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderDetailViewHolder {
        return OrderDetailViewHolder(
            OrderDetailsViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OrderDetailViewHolder, position: Int) {
        val orderDetails = orderDetailsList[position]
        holder.bind(orderDetails)
    }

    override fun getItemCount() = orderDetailsList.size

    inner class OrderDetailViewHolder(val binding: OrderDetailsViewBinding) :
        ViewHolder(binding.root) {
        fun bind(orderDetails: OrderDetails) {
            binding.customerNameTextView.text = orderDetails.customerName
            if (orderDetails.paymentStatus) {
                binding.paymentStatusTextView.text = "Received"
                binding.paymentStatusTextView.setTextColor(
                    ContextCompat.getColor(
                        binding.paymentStatusTextView.context,
                        R.color.green
                    )
                )
            } else {
                binding.paymentStatusTextView.text = "Not Received"
                binding.paymentStatusTextView.setTextColor(
                    ContextCompat.getColor(
                        binding.paymentStatusTextView.context,
                        R.color.red
                    )
                )
            }

            if (orderDetails.deliveryStatus){
                binding.deliveryStatusTextView.text = "Delivered"
                binding.deliveryStatusImageView.setImageResource(R.drawable.ic_circle_green)
            }else{
                binding.deliveryStatusTextView.text = "Delivery Pending"
                binding.deliveryStatusImageView.setImageResource(R.drawable.ic_circle_red)
            }
        }
    }
}