package com.fillah.massiveaha.one

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.databinding.ActivityTipsBinding

class TipsAct : AppCompatActivity() {

    private lateinit var binding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extra = intent.getStringExtra("category")

        binding.btnOk.setOnClickListener {
            if (extra != null){
                Intent(applicationContext, CategoryItem::class.java).also {
                    startActivity(it)
                }
            }
            else{
                finish()
            }

        }




    }
}