package com.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.wavesoffood.R
import com.wavesoffood.databinding.FragmentChooseYourLocationBinding

class ChooseYourLocationFragment : Fragment() {
private lateinit var binding: FragmentChooseYourLocationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choose_your_location, container, false)

        val locationList = arrayOf("Jaipur","Delhi","Hisar")
        val adapter = ArrayAdapter(requireContext(),android.R.layout.simple_list_item_1,locationList)
        binding.autoCompleteText.setAdapter(adapter)

        return binding.root
    }

}