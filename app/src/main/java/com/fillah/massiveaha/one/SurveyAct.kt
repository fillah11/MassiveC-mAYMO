package com.fillah.massiveaha.one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ActivitySurveyBinding
import com.fillah.massiveaha.two.HomeAct
import kotlinx.android.synthetic.main.activity_survey.*

class SurveyAct : AppCompatActivity() {

    private lateinit var binding: ActivitySurveyBinding

    private val surveyAdapter = SurveyAdapter(
        listOf(
            SurveyClass(
                R.drawable.survey1,
                "Apakah Anda tahu cara mengelola keuangan dengan baik?"
            ),
            SurveyClass(
                R.drawable.survey2,
                "Apakah Anda membutuhkan template pengelolaan keuangan?"
            )
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        survey.adapter = surveyAdapter

        binding.survey.isUserInputEnabled = false

        setIndicators()

        survey.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
            }
        )

        binding.btnYa.setOnClickListener{
            if (survey.currentItem + 1 < surveyAdapter.itemCount){
                survey.currentItem += 1
            } else {
                Intent(applicationContext, OnBoarding::class.java).also {
                    it.putExtra("template","yes")
                    startActivity(it)
                }
            }
        }

        binding.btnTidak.setOnClickListener{
            if (survey.currentItem + 1 < surveyAdapter.itemCount){
                survey.currentItem += 1
            } else {
                Intent(applicationContext, OnBoarding::class.java).also {
                    it.putExtra("template","no")
                    startActivity(it)
                }
            }
        }

        binding.btnBack.setOnClickListener{
            if (survey.currentItem > 0){
                survey.currentItem -= 1
            } else {
                finish()
            }
        }
    }

    private fun setIndicators(){
        val indicators = arrayOfNulls<ImageView>(surveyAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams = LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(48,0,48,0)
        for (i in indicators.indices){
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicators_container.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int){
        val childCount = indicators_container.childCount
        for (i in 0 until childCount){
            val imageView = indicators_container[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}