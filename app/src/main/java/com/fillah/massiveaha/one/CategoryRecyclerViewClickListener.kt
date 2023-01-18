package com.fillah.massiveaha.one

import android.view.View

interface CategoryRecyclerViewClickListener {
    fun onCategoryItemClicked(category : List<CategoryClass>, categoryPosition: Int, categoryItemView: View, categoryItemPosition: Int)
}