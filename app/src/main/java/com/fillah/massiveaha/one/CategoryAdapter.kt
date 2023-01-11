package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ActivityCategoryItemBinding

class CategoryAdapter (private val categories: List<CategoryClass>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){

    inner class ViewHolder(
        val categoryBinding: ActivityCategoryItemBinding
    ) : RecyclerView.ViewHolder(categoryBinding.root)

    override fun getItemCount() = categories.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.activity_category_item,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryViewModel = categories[position]

        holder.categoryBinding.tvCategoryHead.text = categoryViewModel.header
        holder.categoryBinding.tvCategoryInstruction.text = categoryViewModel.instruction
        holder.categoryBinding.tvCategoryDescription.text = categoryViewModel.description

//
//        val categoryItemAdapter = CategoryItemAdapter()
//
//        holder.categoryBinding.rvCategory =

    }

}