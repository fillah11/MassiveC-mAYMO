package com.fillah.massiveaha.one

data class CategoryClass (
    val header: String,
    val instruction: String,
    val description: String,
    val item: List<CategoryItemClass>,
    val background: Int
        )