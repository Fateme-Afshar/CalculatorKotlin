package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.Observer
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.databinding.FragmentCalculateBinding
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import com.calculator.calculatorkotlin.viewModel.CalculatorVM

const val DIRECTION_ONE_ARGS = "directionOne"
const val DIRECTION_TWO_ARGS = "directionTwo"

class CalculateDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentCalculateBinding
    private lateinit var viewModel:CalculatorVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel= CalculatorVM(CalculatorRepository.getInstance(requireActivity().applicationContext), it.getSerializable(
                    DIRECTION_ONE_ARGS) as DirectionModel,
                it.getSerializable(DIRECTION_TWO_ARGS) as DirectionModel
            )
        }

        viewModel.getBtnClickListener().observe(this, Observer {
                result ->
            run {
                binding.btnCalculate.text = result
                binding.btnSave.visibility = View.VISIBLE
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calculate, container, false)
        binding.viewModel=viewModel
        return binding.root
    }

companion object{
    @JvmStatic
    fun newInstance(directionOne: DirectionModel, directionTwo: DirectionModel)=
        CalculateDialogFragment().apply {
            arguments = Bundle().apply {
                this.putSerializable(DIRECTION_ONE_ARGS, directionOne)
                this.putSerializable(DIRECTION_TWO_ARGS, directionTwo)
            }
        }
}
}