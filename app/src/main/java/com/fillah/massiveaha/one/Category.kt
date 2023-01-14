package com.fillah.massiveaha.one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ActivityOnBoardingCategoryBinding
import com.fillah.massiveaha.two.HomeAct
import kotlinx.android.synthetic.main.activity_on_boarding_category.*

class Category : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_on_boarding_category)

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

        val categoryList = listOf(
            CategoryClass(
                "Dana Pokok",
                "(Silahkan pilih jenis dana pokok yang Anda inginkan)",
                "Dana pokok digunakan untuk membayar tagihan bulanan dan kebutuhan pokok. Misalnya seperti listrik, belanja bulanan, cicilan, serta biaya transportasi.",
                categoryItems,
                R.drawable.persen_50
            ),
            CategoryClass(
                "Dana Fleksibel",
                "(Silahkan pilih jenis dana fleksibel yang Anda inginkan)",
                "Dana fleksibel digunakan untuk membeli barang yang anda inginkan tetapi tidak esensial. Contohnya membeli baju, menonton bioskop, atau bepergian.",
                categoryItems,
                R.drawable.persen_30
            ),
            CategoryClass(
                "Dana Investasi",
                "(Silahkan pilih jenis dana investasi yang Anda inginkan)",
                "Dana investasi dialokasikan untuk mencapai tujuan finansial seperti investasi, tabungan, dan asuransi. Dana ini dapat digunakan sebagai dana darurat.",
                categoryItems,
                R.drawable.persen_20
            )
        )

        val categoryAdapter = CategoryAdapter(categoryList)

        category.adapter = categoryAdapter

        category.isUserInputEnabled = false

        binding.btnOk.setOnClickListener{
            if (category.currentItem + 1 < categoryAdapter.itemCount){
                category.currentItem += 1
            } else {
                Intent(applicationContext, HomeAct::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        }
    }
}