package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.OnBoardingCategoryItemBinding

class CategoryItemAdapter (private val categoryItems: List<CategoryItemClass>) : RecyclerView.Adapter<CategoryItemAdapter.ViewHolder>(){

    inner class ViewHolder(
        val categoryItemBinding: OnBoardingCategoryItemBinding
    ) : RecyclerView.ViewHolder(categoryItemBinding.root)

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

        val categoryItemsViewModel = categoryItems[position]

        holder.categoryItemBinding.imgCategory.setImageResource(categoryItemsViewModel.img)
        holder.categoryItemBinding.tvCategory.text = categoryItemsViewModel.category
    }

}