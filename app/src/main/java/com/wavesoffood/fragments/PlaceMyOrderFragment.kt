package com.wavesoffood.fragments

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import com.wavesoffood.MainActivity
import com.wavesoffood.R
import com.wavesoffood.databinding.FragmentPlaceMyOrderBinding

class PlaceMyOrderFragment : Fragment() {

    private lateinit var binding: FragmentPlaceMyOrderBinding
    private lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_place_my_order, container, false)
        navController = (activity as MainActivity).getNavController()
        binding.totalPriceTextView.text = "$ ${arguments?.getInt("totalPrice")}"



        binding.backArrowImg.setOnClickListener {
            navController.popBackStack()
        }

        binding.placeOrderButton.setOnClickListener {
            placeOrderButtonClicked(binding)
        }


        return binding.root
    }

    private fun orderPlaceDialog(context: Context, goToHome: () -> Unit): AlertDialog? {
        val builder = AlertDialog.Builder(context, R.style.PlaceOrderDialog)
            .create()
        val view = layoutInflater.inflate(R.layout.place_order_dialog_view, null)
        val button = view.findViewById<Button>(R.id.goToHomeButton)
        builder.setView(view)
        button.setOnClickListener {
            builder.dismiss()
            goToHome()
        }
        builder.setCanceledOnTouchOutside(false)
        return builder
    }

    private fun placeOrderButtonClicked(binding: FragmentPlaceMyOrderBinding) {
        if (binding.enterName.text.isEmpty()) {
            binding.nameErrorLabel.visibility = View.VISIBLE

        } else if (binding.enterAddress.text.isEmpty()) {
            binding.addressErrorLabel.visibility = View.VISIBLE

        } else if (binding.enterPhoneNumber.text.isEmpty()) {
            binding.phoneNumberErrorLabel.visibility = View.VISIBLE
        }else{
            orderPlaceDialog(requireContext(),
                goToHome = {
                    navController.navigate(R.id.action_placeMyOrderFragment_to_homeFragment)
                })?.show()
        }
    }

}