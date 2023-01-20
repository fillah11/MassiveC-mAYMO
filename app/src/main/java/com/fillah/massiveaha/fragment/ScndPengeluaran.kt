package com.fillah.massiveaha.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.fillah.massiveaha.R

class ScndPengeluaran : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scnd_pengeluaran)


        val img_second = findViewById<ImageView>(R.id.img_second)
        val tv_title_second = findViewById<TextView>(R.id.tv_title_secondActivity)

        val intent = intent

        val image = intent?.getIntExtra("image",0)
        val title = intent?.getStringExtra("title")



        if (image != null) {
            img_second.setImageResource(image)
        }

        tv_title_second.text = title
    }
}