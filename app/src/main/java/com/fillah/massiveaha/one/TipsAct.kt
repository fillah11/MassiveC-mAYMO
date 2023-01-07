package com.fillah.massiveaha.one

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fillah.massiveaha.R
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