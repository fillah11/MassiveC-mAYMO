package com.fillah.massiveaha.one

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentEditKategoriBinding
import kotlinx.android.synthetic.main.list_kategori_pengeluaran.*

class EditKategoriFragment : Fragment(), IconClickListener {

    private lateinit var _binding: FragmentEditKategoriBinding
    private val binding get() = _binding

    private val iconList = listOf(
        IconClass(R.drawable.belanja_v1),
        IconClass(R.drawable.belanja_v2),
        IconClass(R.drawable.belanja_v3),
        IconClass(R.drawable.belanja_v4),
        IconClass(R.drawable.belanja),
        IconClass(R.drawable.belanja_v6),
        IconClass(R.drawable.belanja_v7),
        IconClass(R.drawable.belanja_v8)
    )

    private val icons = mapOf(
        "Belanja" to iconList
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentEditKategoriBinding.inflate(inflater, container, false)

        val args = this.arguments
        val category = args?.get("kategori")
        val icon = args?.get("icon")

        binding.imgIcon.setImageResource(icon as Int)
        binding.tvCategory.text = category as String

        val adapter = icons[category]?.let { IconAdapter(it) }
        adapter?.iconClickListener = this

        binding.rvIcon.apply {
            this.adapter = adapter
            this.layoutManager = GridLayoutManager(this.context, 4, )
        }

        return binding.root
    }

    override fun onItemClicked(img: Int, view: View) {
        view.alpha = 0.4f
    }

}