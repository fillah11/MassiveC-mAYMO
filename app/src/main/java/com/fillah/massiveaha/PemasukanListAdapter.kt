package com.example.latihanrecylerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.PemasukanTerkini
import com.fillah.massiveaha.R
import java.nio.file.Files.size

class PemasukanListAdapter(private val pemasukan: ArrayList<PemasukanTerkini>): RecyclerView.Adapter<PemasukanListAdapter.PemasukanViewHolder>(){
    class PemasukanViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tv_listPemasukan: TextView = itemView.findViewById(R.id.tv_listPemasukan)
        var tv_jlhPemasukan: TextView = itemView.findViewById(R.id.tv_jlhPemasukan)
        val pv_pemasukan: ImageView = itemView.findViewById(R.id.pv_pemasukan)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PemasukanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pemasukan_terkini, parent, false)
        return PemasukanViewHolder(view)
        //mengkaitkan list item dengan adapater

    }

    override fun onBindViewHolder(holder: PemasukanViewHolder, position: Int) {
        val (name, description, photo) = pemasukan[position]
        holder.tv_listPemasukan.text = name
        holder.tv_jlhPemasukan.text = description
        holder.pv_pemasukan.setImageResource(photo)
    }

    override fun getItemCount(): Int {
        return pemasukan.size
    }
}
