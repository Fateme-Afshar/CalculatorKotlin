package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.databinding.FragmentAddDirectionBinding
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.DirectionRepository
import com.calculator.calculatorkotlin.viewModel.AddDirectionVM
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddDirectionFragment : DialogFragment() {
    private lateinit var binding: FragmentAddDirectionBinding
    private lateinit var addDirectionVM: AddDirectionVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addDirectionVM= AddDirectionVM(activity!!.application, DirectionRepository.getInstance(
            activity!!.applicationContext))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_add_direction,container,true)
        binding.fragment=this
        binding.viewModel=addDirectionVM
        return binding.root
    }
}