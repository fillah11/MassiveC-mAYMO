package com.fillah.massiveaha.one

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.MainActivity
import com.fillah.massiveaha.databinding.ActivityOnBoardingBinding
import com.fillah.massiveaha.two.HomeAct
import java.text.NumberFormat
import java.util.Locale

class OnBoarding : AppCompatActivity() {

    private lateinit var binding: ActivityOnBoardingBinding
    private val functions = Functions()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val template = intent.getStringExtra("template")
        val inputPemasukan = binding.inputPemasukan.text



        binding.btnSimpan.setOnClickListener{

            if (inputPemasukan.isEmpty()){
                binding.inputPemasukan.error = "harap masukan pendapatan!"
                binding.inputPemasukan.requestFocus()
                return@setOnClickListener
            }

            //kalo lolos validasi
            if (template == "yes"){
                Intent(applicationContext, TipsAct::class.java).also {
                    functions.updateTemplate(inputPemasukan.toString().toInt())
                    it.putExtra("category", template)
                    startActivity(it)
                }
            } else{
                Intent(applicationContext, MainActivity::class.java).also {
                    functions.updateTanpaTemplate(inputPemasukan.toString().toInt())
                    functions.finishedIntro()
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        }
    }
}