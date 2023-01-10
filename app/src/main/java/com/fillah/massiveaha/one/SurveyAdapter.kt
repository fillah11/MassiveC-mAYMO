package com.fillah.massiveaha.one

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.databinding.DataBindingUtil
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.SurveyItemContainerBinding
import org.w3c.dom.Text

class SurveyAdapter(private val surveys: List<SurveyClass>) : RecyclerView.Adapter<SurveyAdapter.SurveyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurveyViewHolder {
        return SurveyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.survey_item_container,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return surveys.size
    }

    override fun onBindViewHolder(holder: SurveyViewHolder, position: Int) {
        holder.bind(surveys[position])
    }

    inner class SurveyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val img = view.findViewById<ImageView>(R.id.img_survey)
        private val question = view.findViewById<TextView>(R.id.tv_survey)

        fun bind(surveys: SurveyClass){
            img.setImageResource(surveys.img)
            question.text = surveys.question
        }
    }



}