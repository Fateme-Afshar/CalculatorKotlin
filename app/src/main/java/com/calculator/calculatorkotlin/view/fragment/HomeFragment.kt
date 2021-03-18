package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.adapter.DirectionAdapter
import com.calculator.calculatorkotlin.databinding.FragmentHomeBinding
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.repository.DirectionRepository
import com.calculator.calculatorkotlin.viewModel.HomeVM

class HomeFragment : BaseFragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel:HomeVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel= HomeVM(DirectionRepository.getInstance(activity!!.applicationContext))

        viewModel.getDirectionList().observe(this,Observer<List<DirectionModel>>{t: List<DirectionModel>? ->
            if (t != null) {
                setupAdapter(t)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getFragmentView(
        inflater: LayoutInflater, container: ViewGroup?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.fragment=this
        return binding.root
    }

    fun onAddDirectionBtnClickListener(){
        var addDirectionFragment=AddDirectionFragment()

        addDirectionFragment.show(childFragmentManager,"addDirectionFragmentTag")
    }

    private fun setupAdapter(directionList: List<DirectionModel>){
        var adapter= activity?.let { DirectionAdapter(it,directionList,baseVM) }
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(activity)
    }
}