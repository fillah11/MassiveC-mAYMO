package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ListEditIconBinding

class IconAdapter (private val iconList: List<IconClass>): RecyclerView.Adapter<IconAdapter.ViewHolder>() {

    var iconClickListener : IconClickListener? = null

    inner class ViewHolder(private val iconBinding: ListEditIconBinding): RecyclerView.ViewHolder(iconBinding.root){
        fun bindItem(icon: IconClass){
            iconBinding.icon.setImageResource(icon.img)

            iconBinding.iconItem.setOnClickListener {
                iconClickListener?.onItemClicked(icon.img, it)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_edit_icon,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(iconList[position])
    }

    override fun getItemCount() = iconList.size


}