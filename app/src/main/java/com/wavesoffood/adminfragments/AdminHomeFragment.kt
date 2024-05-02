package com.wavesoffood.adminfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wavesoffood.MainActivity
import com.wavesoffood.R
import com.wavesoffood.databinding.FragmentAdminHomeBinding


class AdminHomeFragment : Fragment() {
    private lateinit var binding: FragmentAdminHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admin_home, container, false)

        binding.addMenuCard.setOnClickListener {
            (activity as MainActivity).getNavController()
                .navigate(R.id.action_adminHomeFragment_to_addItemFragment)
        }
        binding.allItemCard.setOnClickListener {
            (activity as MainActivity).getNavController()
                .navigate(R.id.action_adminHomeFragment_to_allItemsFragment)
        }

        binding.orderCard.setOnClickListener {
            (activity as MainActivity).getNavController()
                .navigate(R.id.action_adminHomeFragment_to_outOfDeliveryFragment)
        }

        binding.logoutCard.setOnClickListener {
            (activity as MainActivity).getNavController().navigate(R.id.action_adminHomeFragment_to_loginFragment)
        }

        binding.profileCard.setOnClickListener {
            (activity as MainActivity).getNavController()
                .navigate(R.id.action_adminHomeFragment_to_profileFragment)
        }
        binding.adminOrderInfoCustomView.infoImageView.setOnClickListener {
            (activity as MainActivity).getNavController()
                .navigate(R.id.action_adminHomeFragment_to_pendingOrdersFragment)
        }
        binding.adminOrderInfoCustomView.pendingOrderTextView.setOnClickListener {
            (activity as MainActivity).getNavController()
                .navigate(R.id.action_adminHomeFragment_to_pendingOrdersFragment)
        }
        binding.adminOrderInfoCustomView.pendingOrderCount.setOnClickListener {
            (activity as MainActivity).getNavController()
                .navigate(R.id.action_adminHomeFragment_to_pendingOrdersFragment)
        }


        return binding.root
    }

}