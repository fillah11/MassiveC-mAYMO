package com.fillah.massiveaha.one

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.databinding.ActivityAboutBinding

class AboutAct : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var actionBar = getSupportActionBar()


        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        binding.tvNotifikasi.setOnClickListener{
            Toast.makeText(this, "Notifikasi", Toast.LENGTH_SHORT).show()
        }

        binding.tvSuara.setOnClickListener{
            Toast.makeText(this, "Suara", Toast.LENGTH_SHORT).show()
        }

        binding.tvTema.setOnClickListener{
            Toast.makeText(this, "Tema", Toast.LENGTH_SHORT).show()
        }

        binding.tvBahasa.setOnClickListener{
            Toast.makeText(this, "Bahasa", Toast.LENGTH_SHORT).show()
        }

        binding.tvCadangan.setOnClickListener{
            Toast.makeText(this, "Cadangan Google Drive", Toast.LENGTH_SHORT).show()
        }

        binding.tvVersi.setOnClickListener{
            Toast.makeText(this, "Versi", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}