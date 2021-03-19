package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.databinding.FragmentCalculateBinding
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import com.calculator.calculatorkotlin.repository.DirectionRepository
import com.calculator.calculatorkotlin.viewModel.CalculatorVM

const val DIRECTION_ONE_ARGS = "directionIdOne"
const val DIRECTION_TWO_ARGS = "directionTwo"

class CalculateDialogFragment : DialogFragment() {
    private lateinit var binding: FragmentCalculateBinding
    private lateinit var viewModel:CalculatorVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModel= CalculatorVM(CalculatorRepository.getInstance(activity!!.applicationContext),
                DirectionRepository.getInstance(activity!!.applicationContext),it.getInt(
                    DIRECTION_ONE_ARGS),it.getInt(DIRECTION_TWO_ARGS))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calculate, container, false)
        return binding.root
    }

companion object{
    @JvmStatic
    fun newInstance(directionIdOne: Int, directionIdTwo: Int)=
        CalculateDialogFragment().apply {
            arguments = Bundle().apply {
                this.putInt(DIRECTION_ONE_ARGS, directionIdOne)
                this.putInt(DIRECTION_TWO_ARGS, directionIdTwo)
            }
        }
}
}