package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.calculator.calculatorkotlin.repository.DirectionRepository
import com.calculator.calculatorkotlin.viewModel.BaseVM

 abstract class BaseFragment : Fragment() {
     protected lateinit var baseVM: BaseVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseVM= BaseVM(DirectionRepository.getInstance(activity!!.applicationContext))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return getFragmentView(inflater,container)
    }

     abstract fun getFragmentView(inflater: LayoutInflater,
                                  container: ViewGroup?): View
 }