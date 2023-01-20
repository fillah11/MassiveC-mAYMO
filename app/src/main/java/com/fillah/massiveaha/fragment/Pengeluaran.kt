package com.fillah.massiveaha.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R

class Pengeluaran : Fragment()
{


        private lateinit var imageId: Array<Int>
        private lateinit var names: Array<String>

        private lateinit var recView: RecyclerView
        private lateinit var itemArrayList: ArrayList<Icon>

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.fragment_pengeluaran)

            imageId = arrayOf(
                R.drawable.makan_icon,
                R.drawable.jajan_icon,
                R.drawable.belanja_icon,
                R.drawable.hadiah_icon,
                R.drawable.peliharaan_icon,
                R.drawable.laundri_icon,
                R.drawable.utang_icon,
                R.drawable.teknologi_icon,
                R.drawable.pajak_icon,
                R.drawable.sosial_icon,
                R.drawable.rumah_icon,
                R.drawable.liburan_icon,
                R.drawable.kecantikan_icon,
                R.drawable.medis_icon,
                R.drawable.listrik_icon,
                R.drawable.transportasi_icon,
                R.drawable.lalulintas,
                R.drawable.pendidikan_icon,
            )

            names = arrayOf(
                "makan",
                "jajan",
                "belanja",
                "hadiah",
                "peliharaan",
                "Laundri",
                "utang",
                "teknologi",
                "pajak",
                "sosial",
                "rumah",
                "liburan",
                "kecantikan",
                "medis",
                "listrik",
                "transportasi",
                "lalu lintas",
                "pendidikan"

            )



            recView = findViewById(R.id.recView)
            // the type of the recyclerView. linear or grid
            recView.layoutManager = GridLayoutManager(this,3)

            recView.setHasFixedSize(true)


            itemArrayList = arrayListOf()

            getData()

            recView.adapter = RecAadapter(itemArrayList)


        }

        private fun getData() {

            for (i in imageId.indices) {
                val icon = Icon(imageId[i], names[i])
                itemArrayList.add(icon)
            }
        }
    }

    fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pengeluaran, container, false)
    }


