package com.fillah.massiveaha.one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fillah.massiveaha.databinding.ActivityWelcomeBinding

class WelcomeAct : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMengerti.setOnClickListener(){
            val intent = Intent(this, SurveyAct::class.java)
            startActivity(intent)
        }
    }
}