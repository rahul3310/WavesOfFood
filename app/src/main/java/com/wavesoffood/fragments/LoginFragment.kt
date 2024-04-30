package com.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.wavesoffood.MainActivity
import com.wavesoffood.R
import com.wavesoffood.databinding.ActivityMainBinding
import com.wavesoffood.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.loginButton.setOnClickListener { view ->
            (activity as MainActivity).getNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }
        binding.dontHaveAcc.setOnClickListener{view->
            (activity as MainActivity).getNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        return binding.root
    }

}