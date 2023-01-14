package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.OnBoardingCategoryContainerBinding

class CategoryAdapter (private val categories: List<CategoryClass>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){

    inner class ViewHolder(
        val categoryBinding: OnBoardingCategoryContainerBinding
    ) : RecyclerView.ViewHolder(categoryBinding.root)

    override fun getItemCount() = categories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.on_boarding_category_container,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryViewModel = categories[position]

        holder.categoryBinding.tvCategoryHead.text = categoryViewModel.header
        holder.categoryBinding.tvCategoryInstruction.text = categoryViewModel.instruction
        holder.categoryBinding.tvCategoryDescription.text = categoryViewModel.description

        holder.categoryBinding.rvCategory.apply {
            this.adapter = CategoryItemAdapter(categoryViewModel.item)
            this.layoutManager = GridLayoutManager(holder.itemView.context, 2, GridLayoutManager.HORIZONTAL, false)
        }

        holder.categoryBinding.categoryBackground.setImageResource(categoryViewModel.background)

    }

}