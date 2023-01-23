package com.example.latihanrecylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.PemasukanTerkini
import com.fillah.massiveaha.PengeluaranTerkini
import com.fillah.massiveaha.R
import java.nio.file.Files.size

class PengeluaranListAdapter(private val pengeluaran: ArrayList<PengeluaranTerkini>): RecyclerView.Adapter<PengeluaranListAdapter.PengeluaranViewHolder>(){
    class PengeluaranViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tv_listPengeluaran: TextView = itemView.findViewById(R.id.tv_listPengeluaran)
        var tv_jlhPengeluaran: TextView = itemView.findViewById(R.id.tv_jlhPengeluaran)
        val pv_pengeluaran: ImageView = itemView.findViewById(R.id.pv_pengeluaran)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PengeluaranViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pengeluaran_terkini, parent, false)
        return PengeluaranViewHolder(view)
        //mengkaitkan list item dengan adapater

    }

    override fun onBindViewHolder(holder: PengeluaranViewHolder, position: Int) {
        val (name, description, photo) = pengeluaran[position]
        holder.tv_listPengeluaran.text = name
        holder.tv_jlhPengeluaran.text = description
        holder.pv_pengeluaran.setImageResource(photo)
    }

    override fun getItemCount(): Int {
        return pengeluaran.size
    }
}
