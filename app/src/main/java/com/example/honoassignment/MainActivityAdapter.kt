package com.example.honoassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.honoassignment.databinding.ItemAssignmentBinding

class MainActivityAdapter(
    val data: List<MainActivityModel>,
    private val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<MainActivityAdapter.MainActivityViewHolder>() {

    private lateinit var binding: ItemAssignmentBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainActivityViewHolder {
        binding =
            ItemAssignmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return MainActivityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainActivityViewHolder, position: Int) {
        holder.bind(data[position], itemClickListener)
    }

    override fun getItemCount(): Int = data.size ?: 0

    inner class MainActivityViewHolder(private val binding: ItemAssignmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            model: MainActivityModel,
            clickListener: OnItemClickListener
        ) {
            binding.assignmentTv.text = model.assignmentName
            binding.assignmentCv.setOnClickListener {
                clickListener.onItemClicked(model.assignmentName)
            }
        }
    }
}

interface OnItemClickListener {
    fun onItemClicked(assignmentName: String)
}