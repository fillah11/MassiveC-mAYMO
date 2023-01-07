package com.fillah.massiveaha.two

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fillah.massiveaha.R
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
    }
}