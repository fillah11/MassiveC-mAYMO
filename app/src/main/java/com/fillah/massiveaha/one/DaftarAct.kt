package com.fillah.massiveaha.one

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.databinding.ActivityDaftarBinding
import com.fillah.massiveaha.two.HomeAct

class DaftarAct : AppCompatActivity() {

    private lateinit var binding: ActivityDaftarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDaftarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.back.setOnClickListener {
            finish()
        }

        binding.chkDaftar.setOnCheckedChangeListener { _, isChecked ->
            binding.btnDaftar.isEnabled = isChecked
            binding.btnDaftar.isClickable = isChecked
        }

        binding.btnDaftar.setOnClickListener {
            val intent = Intent(this, WelcomeAct::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}