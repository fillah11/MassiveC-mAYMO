package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.OnBoardingCategoryContainerBinding

class CategoryAdapter (private val categories: List<CategoryClass>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>(){

    var categoryListener: CategoryRecyclerViewClickListener? = null

    inner class ViewHolder(private val categoryBinding: OnBoardingCategoryContainerBinding) : RecyclerView.ViewHolder(categoryBinding.root), CategoryItemRecyclerViewClickListener{
        fun bindItem(category: CategoryClass){
            val categoryItem = category.item.toMutableList()
            val adapter = CategoryItemAdapter(categoryItem)
            adapter.categoryItemListener = this

            categoryBinding.tvCategoryHead.text = category.header
            categoryBinding.tvCategoryInstruction.text = category.instruction
            categoryBinding.tvCategoryDescription.text = category.description

            categoryBinding.rvCategory.apply {
                this.adapter = adapter
                this.layoutManager = GridLayoutManager(itemView.context, 2, GridLayoutManager.HORIZONTAL, false)
            }

            categoryBinding.categoryBackground.setImageResource(category.background)
        }

        override fun onItemClicked(
            categoryItemView: View,
            categoryItem: List<CategoryItemClass>,
            categoryItemPosition: Int
        ) {
            categoryListener?.onCategoryItemClicked(
                categories,
                adapterPosition,
                categoryItemView,
                categoryItemPosition
            )
        }
    }

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
        holder.bindItem(categories[position])
    }

}