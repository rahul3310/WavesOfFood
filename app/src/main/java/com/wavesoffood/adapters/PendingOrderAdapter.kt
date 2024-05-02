package com.wavesoffood.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.wavesoffood.databinding.PendingOrderViewBinding
import com.wavesoffood.datamodels.PendingOrderData

class PendingOrderAdapter(
    private val pendingOrderList: ArrayList<PendingOrderData>
) : RecyclerView.Adapter<PendingOrderAdapter.PendingOrderViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PendingOrderAdapter.PendingOrderViewHolder {
        return PendingOrderViewHolder(
            PendingOrderViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: PendingOrderAdapter.PendingOrderViewHolder,
        position: Int
    ) {
        val pendingOrder = pendingOrderList[position]
        holder.bind(pendingOrder)
    }


    override fun getItemCount() = pendingOrderList.size

    inner class PendingOrderViewHolder(val binding: PendingOrderViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pendingOrderData: PendingOrderData) {
            binding.customerName.text = pendingOrderData.customerName
            binding.quantityCountTextView.text = pendingOrderData.quantity.toString()
            if (pendingOrderData.orderState) {
                binding.acceptDispatchButton.text = "Dispatch"
            } else {
                binding.acceptDispatchButton.text = "Accept"
            }
        }
    }
}