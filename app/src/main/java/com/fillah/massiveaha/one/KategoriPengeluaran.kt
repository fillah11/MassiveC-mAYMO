package com.fillah.massiveaha.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentKategoriPengeluaranBinding


class KategoriPengeluaran : Fragment(), KategoriClickListener {

    private lateinit var _binding: FragmentKategoriPengeluaranBinding
    private val binding get() = _binding

    private val editKategoriFragment = EditKategoriFragment()

    private val kategoriPengeluaran = listOf(
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentKategoriPengeluaranBinding.inflate(inflater, container, false)

        val adapter = KategoriPengeluaranAdapter(kategoriPengeluaran)
        adapter.kategoriClickListener = this

        binding.rvPengeluaran.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this.context)
        }

        return binding.root
    }

    override fun onItemClicked(icon: Int, category: String) {
        val bundle = Bundle()
        bundle.putString("kategori", category)
        bundle.putInt("icon", icon)
        println(bundle)
        editKategoriFragment.arguments = bundle

        val transaction: FragmentTransaction =requireFragmentManager().beginTransaction()
        transaction.replace(R.id.frame_layout, editKategoriFragment)
        transaction.addToBackStack("kategori")
        transaction.commit()
    }

}