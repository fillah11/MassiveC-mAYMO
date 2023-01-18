package com.fillah.massiveaha.one

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.MainActivity
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

        binding.btnLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}