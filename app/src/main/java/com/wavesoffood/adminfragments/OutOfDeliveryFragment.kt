package com.wavesoffood.adminfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.wavesoffood.R
import com.wavesoffood.adapters.OrderDetailsAdapter
import com.wavesoffood.databinding.FragmentOutOfDeliveryBinding
import com.wavesoffood.datamodels.OrderDetails

class OutOfDeliveryFragment : Fragment() {
    private lateinit var binding: FragmentOutOfDeliveryBinding
    private val orderDetailsList = ArrayList<OrderDetails>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_out_of_delivery, container, false)

        orderDetailsList.add(OrderDetails("Amit Kumar Verma", deliveryStatus = true,true))
        orderDetailsList.add(OrderDetails("Ritu Ranjan",deliveryStatus =true,true))
        orderDetailsList.add(OrderDetails("Talib",deliveryStatus =false,true))
        orderDetailsList.add(OrderDetails("Aarush",deliveryStatus =true,false))
        orderDetailsList.add(OrderDetails("Rahul Jangra",deliveryStatus =true,true))
        orderDetailsList.add(OrderDetails("Rahul",deliveryStatus =true,true))
        orderDetailsList.add(OrderDetails("Rahul",deliveryStatus =false,true))
        orderDetailsList.add(OrderDetails("Rahul",deliveryStatus =true,true))
        orderDetailsList.add(OrderDetails("Rahul",deliveryStatus =true,false))
        orderDetailsList.add(OrderDetails("Rohit",deliveryStatus =true,true))
        orderDetailsList.add(OrderDetails("Mohit",deliveryStatus =true,true))
        orderDetailsList.add(OrderDetails("Rahul",deliveryStatus =false,true))
        orderDetailsList.add(OrderDetails("Sahil",deliveryStatus =true,true))
        val orderDetailsAdapter = OrderDetailsAdapter(orderDetailsList)
        binding.orderDetailsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.orderDetailsRecyclerView.adapter = orderDetailsAdapter
        return binding.root
    }

}