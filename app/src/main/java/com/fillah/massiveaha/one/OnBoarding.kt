package com.fillah.massiveaha.one

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.MainActivity
import com.fillah.massiveaha.databinding.ActivityOnBoardingBinding
import com.fillah.massiveaha.two.HomeAct

class OnBoarding : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val template = intent.getStringExtra("template")

        binding.btnSimpan.setOnClickListener{
            if (template == "yes"){
                Intent(applicationContext, TipsAct::class.java).also {
                    it.putExtra("category", template)
                    startActivity(it)
                }
            } else{
                Intent(applicationContext, MainActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        }
    }
}