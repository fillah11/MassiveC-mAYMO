package com.fillah.massiveaha.one

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ActivityLoginBinding

class LoginAct : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDaftar.setOnClickListener {
            val intent = Intent(this, DaftarAct::class.java)
            startActivity(intent)
        }
    }
}