package com.fillah.massiveaha.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentAddPemasukanBinding
import com.fillah.massiveaha.databinding.FragmentAddPengeluaranBinding

class FragmentAddPemasukan : Fragment(), KategoriClickListener {
    private var _binding : FragmentAddPemasukanBinding? = null
    private val binding get() = _binding!!

    private val kategoriPemasukan = listOf(
        CategoryItemClass(
            R.drawable.bonus,
            "Bonus"
        ),
        CategoryItemClass(
            R.drawable.gaji,
            "Gaji"
        ),
        CategoryItemClass(
            R.drawable.investasi,
            "Investasi"
        )
    )

    private val addTransaksi = FragmentAddTransaksi()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddPemasukanBinding.inflate(inflater, container, false)

        val adapter = AddTransaksiAdapter(kategoriPemasukan)
        adapter.addClickListener = this

        binding.rvIcon.apply {
            this.adapter = adapter
            this.layoutManager = GridLayoutManager(context, 3)
        }

        return binding.root
    }

    override fun onItemClicked(icon: Int, category: String, jenis: String?) {
        val bundle = Bundle()
        bundle.putString("jenis", "Pemasukan")
        bundle.putString("category", category)
        bundle.putInt("icon", icon)
        addTransaksi.arguments = bundle
        addTransaksi.show(parentFragmentManager, "Fragment Add Transaksi")
    }
}