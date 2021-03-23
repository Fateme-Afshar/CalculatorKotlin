package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.repository.DirectionRepository
import com.calculator.calculatorkotlin.viewModel.BaseVM

abstract class BaseFragment : Fragment() {
     protected lateinit var baseVM: BaseVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseVM= BaseVM(DirectionRepository.getInstance(activity!!.applicationContext))

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        return getFragmentView(inflater,container)
    }

     override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         inflater.inflate(R.menu.main_menu,menu)
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         if (item.itemId==R.id.menu_delete_all){
             baseVM.deleteAll()
             return true
         }
         return super.onOptionsItemSelected(item)
     }

     abstract fun getFragmentView(inflater: LayoutInflater,
                                  container: ViewGroup?): View
 }