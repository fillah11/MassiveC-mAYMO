package com.fillah.massiveaha.one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ActivityCategoryItemBinding

class CategoryItem : AppCompatActivity() {

    private lateinit var binding:ActivityCategoryItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_item)

        val categoryItems = listOf(
            CategoryItemClass(
                R.drawable.makan,
                "Makan"
            ),
            CategoryItemClass(
                R.drawable.jajan,
                "Jajan"
            ),
            CategoryItemClass(
                R.drawable.belanja,
                "Belanja"
            ),
            CategoryItemClass(
                R.drawable.hadiah,
                "Hadiah"
            ),
            CategoryItemClass(
                R.drawable.peliharaan,
                "Peliharaan"
            ),
            CategoryItemClass(
                R.drawable.laundri,
                "Laundri"
            ),
            CategoryItemClass(
                R.drawable.utang,
                "Utang"
            ),
            CategoryItemClass(
                R.drawable.teknologi,
                "Teknologi"
            ),
            CategoryItemClass(
                R.drawable.pajak,
                "Pajak"
            ),
            CategoryItemClass(
                R.drawable.sosial,
                "Sosial"
            ),
            CategoryItemClass(
                R.drawable.rumah,
                "Rumah"
            ),
            CategoryItemClass(
                R.drawable.liburan,
                "Liburan"
            ),
            CategoryItemClass(
                R.drawable.kecantikan,
                "Kecantikan"
            ),
            CategoryItemClass(
                R.drawable.medis,
                "Medis"
            ),
            CategoryItemClass(
                R.drawable.listrik,
                "Listrik"
            ),
            CategoryItemClass(
                R.drawable.transportasi,
                "Transportasi"
            ),
            CategoryItemClass(
                R.drawable.lalulintas,
                "Lalu Lintas"
            ),
            CategoryItemClass(
                R.drawable.pendidikan,
                "Pendidikan"
            )
        )

        val adapter = CategoryItemAdapter(categoryItems)

        binding.rvCategory.apply {
            this.adapter = adapter
            this.layoutManager = GridLayoutManager(this@CategoryItem, 2, GridLayoutManager.HORIZONTAL, false)
        }
    }
}