package com.calculator.calculatorkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.calculator.calculatorkotlin.R
import com.calculator.calculatorkotlin.databinding.ItemViewBinding
import com.calculator.calculatorkotlin.model.DirectionModel
import com.calculator.calculatorkotlin.viewModel.BaseVM

class DirectionAdapter(var context: Context, var directionModels: List<DirectionModel>,var viewModel:BaseVM) :
    RecyclerView.Adapter<DirectionAdapter.Holder>() {

    private var selectionDirectionModel= arrayListOf<DirectionModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = DataBindingUtil.inflate<ItemViewBinding>(
            LayoutInflater.from(context),
            R.layout.item_view,
            parent,
            false
        )
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return directionModels.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemViewBinding.counter = position
        holder.bindView(directionModels[position])

        holder.itemViewBinding.chbSelection.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                selectionDirectionModel.add(directionModels[position])
            else
                selectionDirectionModel.remove(directionModels[position])

            viewModel.getSelectionDirections().value=selectionDirectionModel
        }

        holder.itemViewBinding.imvDelete.setOnClickListener { viewModel.deleteDirectionModel(directionModels[position]) }
    }

    class Holder(var itemViewBinding: ItemViewBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bindView(directionModel: DirectionModel) {
            itemViewBinding.direction = directionModel
        }
    }
}