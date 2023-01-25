package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ListPengeluaranBinding

class PengeluaranTerkiniAdapter(private val pengeluaranTerkini: List<TransactionClass>): RecyclerView.Adapter<PengeluaranTerkiniAdapter.ViewHolder>() {

    private val functions = Functions()

    inner class ViewHolder(private val pengeluaranBinding: ListPengeluaranBinding): RecyclerView.ViewHolder(pengeluaranBinding.root){
        fun bindItem(pengeluaran: TransactionClass){
            pengeluaranBinding.icon.setImageResource(pengeluaran.icon!!)
            pengeluaranBinding.kategori.text = pengeluaran.kategori

            val nominal = functions.formatRupiah(pengeluaran.nominal!!.toDouble()).replace("-","").replace("Rp","-Rp")

            pengeluaranBinding.nominal.text = nominal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_pengeluaran,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(pengeluaranTerkini[position])
    }

    override fun getItemCount() = pengeluaranTerkini.size
}