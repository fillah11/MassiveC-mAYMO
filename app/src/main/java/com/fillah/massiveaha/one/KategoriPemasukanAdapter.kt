package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ListKategoriPemasukanBinding

class KategoriPemasukanAdapter (private val kategoriPemasukan: List<CategoryItemClass>) : RecyclerView.Adapter<KategoriPemasukanAdapter.ViewHolder>() {

    var kategoriClickListener: KategoriClickListener? = null

    inner class ViewHolder(private val pemasukanBinding: ListKategoriPemasukanBinding): RecyclerView.ViewHolder(pemasukanBinding.root){
        fun bindItem(pemasukan: CategoryItemClass){
            pemasukanBinding.imgPemasukan.setImageResource(pemasukan.img)
            pemasukanBinding.tvPemasukan.text = pemasukan.category

            pemasukanBinding.kategoriPemasukan.setOnClickListener {
                kategoriClickListener?.onItemClicked(pemasukan.img, pemasukan.category)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_kategori_pemasukan,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(kategoriPemasukan[position])
    }

    override fun getItemCount() = kategoriPemasukan.size
}