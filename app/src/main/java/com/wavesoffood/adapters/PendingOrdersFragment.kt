package com.wavesoffood.adapters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.wavesoffood.R
import com.wavesoffood.databinding.FragmentPendingOrdersBinding
import com.wavesoffood.datamodels.PendingOrderData

class PendingOrdersFragment : Fragment() {
    private lateinit var binding: FragmentPendingOrdersBinding
    private val pendingOrders = ArrayList<PendingOrderData>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_pending_orders, container, false)

        pendingOrders.add(PendingOrderData("Rahul Jangra", 10, false))
        pendingOrders.add(PendingOrderData("Rahul Jangra", 10, true))
        pendingOrders.add(PendingOrderData("Rahul Jangra", 4, false))
        pendingOrders.add(PendingOrderData("Rahul Jangra", 12, false))
        pendingOrders.add(PendingOrderData("Rahul Jangra", 7, false))
        pendingOrders.add(PendingOrderData("Rahul Jangra", 5, true))
        pendingOrders.add(PendingOrderData("Rahul Jangra", 3, false))
        pendingOrders.add(PendingOrderData("Rahul Jangra", 1, true))

        val pendingOrderAdapter = PendingOrderAdapter(pendingOrders)
        binding.pendingOrderRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.pendingOrderRecyclerView.adapter = pendingOrderAdapter

        return binding.root
    }

}