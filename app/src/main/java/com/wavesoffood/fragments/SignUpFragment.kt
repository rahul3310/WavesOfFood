package com.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.wavesoffood.R
import com.wavesoffood.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
 private lateinit var binding : FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_sign_up,container,false)

        binding.tvAlreadyHaveAcc.setOnClickListener{view->
            view.findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
        binding.createAccountButton.setOnClickListener{view->
            view.findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }

        return binding.root
    }

}