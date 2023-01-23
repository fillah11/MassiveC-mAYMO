package com.fillah.massiveaha.one

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.databinding.FragmentDompetTanpaTemplateBinding

class DompetTanpaTemplateFragment : Fragment() {

    private var _binding: FragmentDompetTanpaTemplateBinding? = null
    private val binding get() = _binding!!
    private val functions = Functions()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        //inflate the layout
        _binding = FragmentDompetTanpaTemplateBinding.inflate(inflater, container, false)

        //get user data
        functions.userData.get()
            .addOnSuccessListener {
                //set nilai aset(sisa saldo) dan pendapatan
                val aset = functions.formatRupiah(it.data?.get("aset").toString().toDouble())
                val pendapatan = "dari ${functions.formatRupiah(it.data?.get("pendapatan").toString().toDouble())}"

                binding.tvAset.text = aset
                binding.tvPendapatan.text = pendapatan
            }
            .addOnFailureListener {
                println("failed to retrieve data. $it")
            }

        return binding.root
    }
}
