package com.fillah.massiveaha.two

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.MainActivity
import com.fillah.massiveaha.databinding.ActivityHomeBinding
import com.fillah.massiveaha.one.AboutAct
import com.fillah.massiveaha.one.TipsAct

class HomeAct : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnTips.setOnClickListener {
            val intent = Intent(this, TipsAct::class.java)
            startActivity(intent)
        }

        binding.btnTentang.setOnClickListener {
            val intent = Intent(this, AboutAct::class.java)
            startActivity(intent)
        }

        binding.btnNavbar.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}