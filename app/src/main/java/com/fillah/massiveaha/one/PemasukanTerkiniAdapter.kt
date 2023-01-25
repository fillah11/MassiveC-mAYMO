package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ListPemasukanBinding

class PemasukanTerkiniAdapter(private val pemasukanTerkini: List<TransactionClass>): RecyclerView.Adapter<PemasukanTerkiniAdapter.ViewHolder>() {

    private val functions = Functions()

    inner class ViewHolder(private val pemasukanBinding: ListPemasukanBinding): RecyclerView.ViewHolder(pemasukanBinding.root){
        fun bindItem(pemasukan: TransactionClass){
            pemasukanBinding.icon.setImageResource(pemasukan.icon!!)
            pemasukanBinding.kategori.text = pemasukan.kategori

            val nominal = functions.formatRupiah(pemasukan.nominal!!.toDouble()).replace("Rp","+Rp")

            pemasukanBinding.nominal.text = nominal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_pemasukan,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pemasukanTerkini[position])
    }

    override fun getItemCount() = pemasukanTerkini.size
}