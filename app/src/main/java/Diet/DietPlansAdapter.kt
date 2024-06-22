package com.example.fitfusion.Diet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fitfusion.databinding.ItemDietPlanBinding

class DietPlansAdapter(
    private val dietPlans: List<DietPlan>,
    private val onItemClick: (DietPlan) -> Unit
) : RecyclerView.Adapter<DietPlansAdapter.DietPlanViewHolder>() {

    inner class DietPlanViewHolder(private val binding: ItemDietPlanBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(dietPlan: DietPlan) {
            binding.textViewDietPlanName.text = dietPlan.name
            binding.imageViewDietPlan.setImageResource(dietPlan.imageResId)
        }

        override fun onClick(v: View?) {
            onItemClick(dietPlans[adapterPosition])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietPlanViewHolder {
        val binding = ItemDietPlanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DietPlanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DietPlanViewHolder, position: Int) {
        holder.bind(dietPlans[position])
    }

    override fun getItemCount(): Int {
        return dietPlans.size
    }
}