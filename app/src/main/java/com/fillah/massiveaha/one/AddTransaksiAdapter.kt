package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ListAddTransaksiBinding

class AddTransaksiAdapter (private val transaksi: List<CategoryItemClass>) : RecyclerView.Adapter<AddTransaksiAdapter.ViewHolder>(){

    var addClickListener: KategoriClickListener? = null

    inner class ViewHolder (private val transaksiBinding: ListAddTransaksiBinding): RecyclerView.ViewHolder(transaksiBinding.root){
        fun bindItem(transaksi: CategoryItemClass){
            transaksiBinding.icon.setImageResource(transaksi.img)
            transaksiBinding.kategoriPengeluaran.text = transaksi.category

            transaksiBinding.iconItem.setOnClickListener {
                addClickListener?.onItemClicked(transaksi.img, transaksi.category, transaksi.jenisAset)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_add_transaksi,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: AddTransaksiAdapter.ViewHolder, position: Int) {
        holder.bindItem(transaksi[position])
    }

    override fun getItemCount() = transaksi.size
}