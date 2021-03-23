package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import com.calculator.calculatorkotlin.repository.DirectionRepository
import com.calculator.calculatorkotlin.viewModel.BaseVM

abstract class BaseFragment : Fragment() {
     protected lateinit var baseVM: BaseVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseVM= BaseVM(DirectionRepository.getInstance(activity!!.applicationContext),
            CalculatorRepository.getInstance(activity!!.applicationContext))

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return getFragmentView(inflater,container)
    }

     abstract fun getFragmentView(inflater: LayoutInflater,
                                  container: ViewGroup?): View

     fun onListBtnClickListener(){
         activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment_container,ShowListFragment())?.commit()
     }
 }