package com.fillah.massiveaha.one

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.databinding.FragmentAddTransaksiBinding

class FragmentAddTransaksi : DialogFragment() {
    private var _binding : FragmentAddTransaksiBinding? = null
    private val binding get() = _binding!!

    private val functions = Functions()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddTransaksiBinding.inflate(inflater, container, false)

        val args = this.arguments
        val jenis = args?.get("jenis").toString()
        val category = args?.get("category").toString()
        val icon = args?.get("icon").toString().toInt()
        val jenisAset = args?.get("jenis_aset").toString()
        println("Jenis $jenis category $category icon $icon, jenis aset $jenisAset")

        binding.kategori.text = category

        val inputTransaksi = binding.inputTransaksi.text

        binding.btnSimpan.setOnClickListener {
            println("kontol lah, $inputTransaksi")
            if (inputTransaksi.isEmpty()){
                binding.inputTransaksi.error = "harap masukkan nominal!"
                binding.inputTransaksi.requestFocus()
                return@setOnClickListener
            }

            if (jenis == "Pengeluaran"){
                val data = hashMapOf(
                    "icon" to icon,
                    "kategori" to category,
                    "nominal" to inputTransaksi.toString().toInt()
                )

                functions.currentExpense.document().set(data)
                    .addOnSuccessListener {
                        Log.i("successfully added!", "$it")
                        functions.updateAddExpense(jenisAset, inputTransaksi.toString().toInt())
                        Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show()
                        dismiss()
                    }
                    .addOnFailureListener {
                        Log.e("add data failed!", it.message.toString())
                    }
            } else {
                val data = hashMapOf(
                    "icon" to icon,
                    "kategori" to category,
                    "nominal" to inputTransaksi.toString().toInt()
                )

                functions.currentIncome.document().set(data)
                    .addOnSuccessListener {
                        Log.i("successfully added!", "$it")
                        functions.updateAddIncome(inputTransaksi.toString().toInt())
                        Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show()
                        dismiss()
                    }
                    .addOnFailureListener {
                        Log.e("add data failed!", it.message.toString())
                    }
            }



        }

        return binding.root
    }
}