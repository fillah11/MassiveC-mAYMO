package com.fillah.massiveaha.one

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.ActivityTipsBinding

class TipsAct : AppCompatActivity() {

    private lateinit var binding: ActivityTipsBinding
    private val functions = Functions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        functions.userData.get()
            .addOnSuccessListener {
                val rule50 = it.data?.get("pokok").toString().toDouble()
                val rule30 = it.data?.get("fleksibel").toString().toDouble()
                val rule20 = it.data?.get("investasi").toString().toDouble()

                val text50 = getString(R.string.tv_tips_1).replace("50XX", functions.formatRupiah(rule50))
                val text30 = getString(R.string.tv_tips_2).replace("30XX", functions.formatRupiah(rule30))
                val text20 = getString(R.string.tv_tips_3).replace("20XX", functions.formatRupiah(rule20))

                binding.tvRule50.text = text50
                binding.tvRule30.text = text30
                binding.tvRule20.text = text20

            }
            .addOnFailureListener {
                Log.e("failed to retrieve data", it.message.toString())
            }

        val extra = intent.getStringExtra("category")

        binding.btnOk.setOnClickListener {
            if (extra != null){
                Intent(applicationContext, Category::class.java).also {
                    startActivity(it)
                }
            }
            else{
                finish()
            }

        }




    }
}