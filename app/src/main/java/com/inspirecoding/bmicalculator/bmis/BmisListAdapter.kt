package com.inspirecoding.bmicalculator.bmis

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.inspirecoding.bmicalculator.databinding.ItemBmiBinding
import com.inspirecoding.bmicalculator.model.BMI
import com.inspirecoding.bmicalculator.bmis.BmisListAdapter.BmiViewHolder

class BmisListAdapter(private val viewModel: BmisViewModel): ListAdapter<BMI, BmiViewHolder>(BmiDiffCallback())
{
    override fun onCreateViewHolder(parent: ViewGroup, position: Int): BmiViewHolder
    {
        return BmiViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: BmiViewHolder, position: Int)
    {
        val item = getItem(position)
        holder.bind(viewModel, item)
    }

    class BmiViewHolder private constructor(val binding: ItemBmiBinding): RecyclerView.ViewHolder(binding.root)
    {
        fun bind(viewModel: BmisViewModel, bmi: BMI)
        {
            binding.viewModel = viewModel
            binding.bmi = bmi
        }

        companion object
        {
            fun from(parent: ViewGroup): BmiViewHolder
            {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemBmiBinding.inflate(layoutInflater, parent, false)

                return BmiViewHolder(binding)
            }
        }
    }
}


/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class BmiDiffCallback : DiffUtil.ItemCallback<BMI>()
{
    override fun areItemsTheSame(oldItem: BMI, newItem: BMI): Boolean
    {
        return oldItem.bmiId == newItem.bmiId
    }

    override fun areContentsTheSame(oldItem: BMI, newItem: BMI): Boolean
    {
        return oldItem == newItem
    }
}