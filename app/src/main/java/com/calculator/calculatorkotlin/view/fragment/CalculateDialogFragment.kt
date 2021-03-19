package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.databinding.FragmentCalculateBinding

class CalculateDialogFragment :DialogFragment(){
    private lateinit var binding: FragmentCalculateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater, R.layout.fragment_calculate,container,false)
        return binding.root
    }
}