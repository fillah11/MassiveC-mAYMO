package com.fillah.massiveaha.one

import android.view.View

interface CategoryItemRecyclerViewClickListener {

    fun onItemClicked(categoryItemView: View, categoryItem: List<CategoryItemClass>, categoryItemPosition: Int)
}