package com.fillah.massiveaha.one

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fillah.massiveaha.databinding.ActivityCategory1Binding

class Category1 : AppCompatActivity() {

    private lateinit var binding:ActivityCategory1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategory1Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}