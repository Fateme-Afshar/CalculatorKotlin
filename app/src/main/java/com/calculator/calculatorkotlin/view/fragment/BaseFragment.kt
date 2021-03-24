package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.repository.CalculatorRepository
import com.calculator.calculatorkotlin.repository.DirectionRepository
import com.calculator.calculatorkotlin.viewModel.BaseVM

abstract class BaseFragment() : Fragment() {
     protected lateinit var baseVM: BaseVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Return the  FragmentActivity this fragment is currently associated with.
        baseVM= BaseVM(DirectionRepository.getInstance(requireActivity().applicationContext),
            CalculatorRepository.getInstance(requireActivity().applicationContext))

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
         var navController= activity?.let { Navigation.findNavController(it,R.id.nav_host_fragment) }

         var navDirections=object :NavDirections{
             override fun getActionId(): Int {
                 return R.id.action_fragment_home_to_showListFragment
             }

             override fun getArguments(): Bundle {
                 return Bundle()
             }

         }

         navController?.navigate(navDirections)
     }
 }