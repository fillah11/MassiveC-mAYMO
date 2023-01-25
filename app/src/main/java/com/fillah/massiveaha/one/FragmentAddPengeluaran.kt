package com.fillah.massiveaha.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentAddPengeluaranBinding

class FragmentAddPengeluaran : Fragment(), KategoriClickListener {

    private var _binding : FragmentAddPengeluaranBinding? = null
    private val binding get() = _binding!!

    private val kategoriPengeluaran = listOf(
        CategoryItemClass(
            R.drawable.makan,
            "Makan",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.jajan,
            "Jajan",
            "aset_fleksibel"
        ),
        CategoryItemClass(
            R.drawable.belanja,
            "Belanja",
            "aset_fleksibel"
        ),
        CategoryItemClass(
            R.drawable.hadiah,
            "Hadiah",
            "aset_fleksibel"
        ),
        CategoryItemClass(
            R.drawable.peliharaan,
            "Peliharaan",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.laundri,
            "Laundri",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.utang,
            "Utang",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.teknologi,
            "Teknologi",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.pajak,
            "Pajak",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.sosial,
            "Sosial",
            "aset_fleksibel"
        ),
        CategoryItemClass(
            R.drawable.rumah,
            "Rumah",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.liburan,
            "Liburan",
            "aset_fleksibel"
        ),
        CategoryItemClass(
            R.drawable.kecantikan,
            "Kecantikan",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.medis,
            "Medis",
            "aset_fleksibel"
        ),
        CategoryItemClass(
            R.drawable.listrik,
            "Listrik",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.transportasi,
            "Transportasi",
            "aset_pokok"
        ),
        CategoryItemClass(
            R.drawable.lalulintas,
            "Lalu Lintas",
            "aset_fleksibel"
        ),
        CategoryItemClass(
            R.drawable.pendidikan,
            "Pendidikan",
            "aset_pokok"
        )
    )

    private val addTransaksi = FragmentAddTransaksi()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddPengeluaranBinding.inflate(inflater, container, false)

        val adapter = AddTransaksiAdapter(kategoriPengeluaran)
        adapter.addClickListener = this

        binding.rvIcon.apply {
            this.adapter = adapter
            this.layoutManager = GridLayoutManager(context, 3)
        }

        return binding.root
    }

    override fun onItemClicked(icon: Int, category: String, jenis: String?) {
        val bundle = Bundle()
        bundle.putString("jenis", "Pengeluaran")
        bundle.putString("category", category)
        bundle.putInt("icon", icon)
        bundle.putString("jenis_aset", jenis)
        addTransaksi.arguments = bundle
        addTransaksi.show(parentFragmentManager, "Fragment Add Transaksi")
    }

}