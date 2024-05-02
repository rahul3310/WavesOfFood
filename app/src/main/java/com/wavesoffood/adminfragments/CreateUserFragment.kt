package com.wavesoffood.adminfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.wavesoffood.R
import com.wavesoffood.databinding.FragmentCreateUserBinding


class CreateUserFragment : Fragment() {

    private lateinit var binding: FragmentCreateUserBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_create_user, container, false)

        return binding.root
    }

}