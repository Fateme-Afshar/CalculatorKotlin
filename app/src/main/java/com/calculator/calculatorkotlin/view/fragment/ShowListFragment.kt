package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.adapter.CalculatorAdapter
import com.calculator.calculatorkotlin.adapter.DirectionAdapter
import com.calculator.calculatorkotlin.databinding.FragmentShowListBinding
import com.calculator.calculatorkotlin.model.CalculateModel
import com.calculator.calculatorkotlin.model.DirectionModel


class ShowListFragment : BaseFragment() {
    private lateinit var binding: FragmentShowListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        baseVM.getCalculatedDirectionList().observe(this, Observer {
            setupAdapter(it)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.menu_save){
            //TODO :  SAVE ALL IN FILE
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun getFragmentView(inflater: LayoutInflater, container: ViewGroup?): View {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_show_list,container,false)
        return binding.root
    }

    private fun setupAdapter(calculateList: List<CalculateModel>){
        var adapter= activity?.let { CalculatorAdapter(it,calculateList) }
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager= LinearLayoutManager(activity)
    }
}