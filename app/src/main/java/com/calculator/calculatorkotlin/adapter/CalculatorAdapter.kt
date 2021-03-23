package com.calculator.calculatorkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.databinding.ItemResultBinding
import com.calculator.calculatorkotlin.databinding.ItemViewBinding
import com.calculator.calculatorkotlin.model.CalculateModel
import com.calculator.calculatorkotlin.model.DirectionModel

class CalculatorAdapter(private val context:Context,private var calculatorList: List<CalculateModel>):RecyclerView.Adapter<CalculatorAdapter.Holder>() {

        private var selectionDirectionModel= arrayListOf<DirectionModel>()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            val binding = DataBindingUtil.inflate<ItemResultBinding>(
                LayoutInflater.from(context),
                R.layout.item_result,
                parent,
                false
            )
            return Holder(binding)
        }

        override fun getItemCount(): Int {
            return calculatorList.size
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.bindView(calculatorList[position])
        }

        class Holder(var itemResultBinding: ItemResultBinding) :
            RecyclerView.ViewHolder(itemResultBinding.root) {
            fun bindView(calculateModel: CalculateModel) {
                itemResultBinding.calculator = calculateModel
            }
        }
}