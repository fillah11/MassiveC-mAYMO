package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentKategoriPengeluaranBinding
import com.fillah.massiveaha.databinding.ListKategoriPengeluaranBinding

class KategoriPengeluaranAdapter (private val kategoriPengeluaran: List<CategoryItemClass>) : RecyclerView.Adapter<KategoriPengeluaranAdapter.ViewHolder>() {

    var kategoriClickListener: KategoriClickListener? = null

    inner class ViewHolder(private val pengeluaranBinding: ListKategoriPengeluaranBinding): RecyclerView.ViewHolder(pengeluaranBinding.root){
        fun bindItem(pengeluaran: CategoryItemClass){
            pengeluaranBinding.imgPengeluaran.setImageResource(pengeluaran.img)
            pengeluaranBinding.tvPengeluaran.text = pengeluaran.category

            pengeluaranBinding.kategoriPengeluaran.setOnClickListener {
                kategoriClickListener?.onItemClicked(pengeluaran.img, pengeluaran.category)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_kategori_pengeluaran,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(kategoriPengeluaran[position])
    }

    override fun getItemCount() = kategoriPengeluaran.size
}