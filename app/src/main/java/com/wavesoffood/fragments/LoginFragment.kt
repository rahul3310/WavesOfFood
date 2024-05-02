package com.wavesoffood.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wavesoffood.BuildConfig
import com.wavesoffood.MainActivity
import com.wavesoffood.R
import com.wavesoffood.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        if (BuildConfig.BUILD_IDENTIFIER == "admin"){
            binding.appDescripsion.visibility= View.GONE
            binding.loginTv.text = "Login To Your \n" +"Admin Dashboard"
        }
        binding.loginButton.setOnClickListener { view ->
            if (BuildConfig.BUILD_IDENTIFIER == "admin") {
                (activity as MainActivity).getNavController()
                    .navigate(R.id.action_loginFragment_to_admin_navigation_graph)
            } else {
                (activity as MainActivity).getNavController()
                    .navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }
        binding.dontHaveAcc.setOnClickListener { view ->
            (activity as MainActivity).getNavController()
                .navigate(R.id.action_loginFragment_to_signUpFragment)
        }


        return binding.root
    }

}