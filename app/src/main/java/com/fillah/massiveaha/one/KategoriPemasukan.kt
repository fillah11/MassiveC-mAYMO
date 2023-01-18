package com.fillah.massiveaha.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentKategoriPemasukanBinding

class KategoriPemasukan : Fragment(), KategoriClickListener {

    private lateinit var _binding: FragmentKategoriPemasukanBinding
    private val binding get() = _binding

    private val editKategoriFragment =  EditKategoriFragment()

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        _binding = FragmentKategoriPemasukanBinding.inflate(inflater, container, false)

        val adapter = KategoriPemasukanAdapter(kategoriPemasukan)
        adapter.kategoriClickListener = this

        binding.rvPemasukan.apply{
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