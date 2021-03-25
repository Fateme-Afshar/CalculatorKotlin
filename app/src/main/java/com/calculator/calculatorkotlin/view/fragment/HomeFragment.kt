package com.calculator.calculatorkotlin.view.fragment

import android.os.Bundle
import android.view.*
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

    private var selectionDirections= mutableListOf<DirectionModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel= HomeVM(DirectionRepository.getInstance(requireActivity().applicationContext))

        baseVM.getSelectionDirections().observe(this, Observer<List<DirectionModel>>{directionModelList: List<DirectionModel>? ->
            if (directionModelList!=null){
                if(directionModelList.size==2) {
                    binding.btnCalculate.visibility = View.VISIBLE
                    selectionDirections.apply {
                        this.clear()
                        this.add(directionModelList[0])
                        this.add(directionModelList[1])
                    }
                }
                else
                    binding.btnCalculate.visibility=View.GONE
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        baseVM.getDirectionList().observe(viewLifecycleOwner,Observer<List<DirectionModel>>{t: List<DirectionModel>? ->
            if (t != null) {
                setupAdapter(t)
                binding.btnCalculate.visibility=View.GONE

                if(t.isEmpty())
                    binding.animationView.visibility=View.VISIBLE
                else
                    binding.animationView.visibility=View.GONE
            }
        })
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

    fun onCalculateBtnClickListener(){
        var calculateDialogFragment=CalculateDialogFragment.newInstance(selectionDirections[0],selectionDirections[1])

        calculateDialogFragment.show(childFragmentManager,"calculateFragmentTag")
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.menu_delete_all){
            baseVM.deleteAllDirections()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupAdapter(directionList: List<DirectionModel>){
        var adapter= activity?.let { DirectionAdapter(it,directionList,baseVM) }
        binding.recyclerView.adapter=adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(activity)
    }
}