package com.fillah.massiveaha.one

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.databinding.ActivityTipsBinding

class TipsAct : AppCompatActivity() {

    private lateinit var binding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOk.setOnClickListener {
            finish()
        }
    }
}