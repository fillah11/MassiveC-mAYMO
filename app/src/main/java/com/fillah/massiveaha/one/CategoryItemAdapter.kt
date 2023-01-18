package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.OnBoardingCategoryItemBinding

class CategoryItemAdapter (private val categoryItems: List<CategoryItemClass>) : RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>(){

    var categoryItemListener: CategoryItemRecyclerViewClickListener? = null

    inner class ViewHolder(private val categoryItemBinding: OnBoardingCategoryItemBinding) : RecyclerView.ViewHolder(categoryItemBinding.root){
        fun bindItem(categoryItem: CategoryItemClass){
            categoryItemBinding.imgCategory.setImageResource(categoryItem.img)
            categoryItemBinding.tvCategory.text = categoryItem.category

            categoryItemBinding.categoryItem.setOnClickListener {
                categoryItemListener?.onItemClicked(it, categoryItems, adapterPosition)
            }
        }
    }

    override fun getItemCount() = categoryItems.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.on_boarding_category_item,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(categoryItems[position])
    }
}