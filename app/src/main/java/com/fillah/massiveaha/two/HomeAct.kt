package com.fillah.massiveaha.two

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.databinding.ActivityHomeBinding

class HomeAct : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}