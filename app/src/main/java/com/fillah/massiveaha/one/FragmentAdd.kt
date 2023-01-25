package com.fillah.massiveaha.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentAddBinding

class FragmentAdd : DialogFragment() {

    private var _binding : FragmentAddBinding? = null
    private val binding get() = _binding!!

    private val pengeluaran = FragmentAddPengeluaran()
    private val pemasukan = FragmentAddPemasukan()

    private var btnPengeluaran = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        parentFragmentManager.beginTransaction()
            .add(binding.iconTransaksi.id, pengeluaran)
            .commit()

        switch()

        binding.btnClose.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    private fun switch(){
        binding.btnPemasukan.alpha = 0.4f
        binding.btnPengeluaran.setOnClickListener{
            if (!btnPengeluaran){
                btnPengeluaran = true
                binding.btnPengeluaran.alpha = 1f
                binding.btnPemasukan.alpha = 0.4f

                parentFragmentManager.beginTransaction()
                    .replace(binding.iconTransaksi.id, pengeluaran)
                    .commit()
            } else {
                return@setOnClickListener
            }
        }
        binding.btnPemasukan.setOnClickListener{
            if (!btnPengeluaran){
                return@setOnClickListener
            } else {
                btnPengeluaran = false
                binding.btnPengeluaran.alpha = 0.4f
                binding.btnPemasukan.alpha = 1f

                parentFragmentManager.beginTransaction()
                    .replace(binding.iconTransaksi.id, pemasukan)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        parentFragmentManager.beginTransaction()
            .remove(pengeluaran)
            .remove(pemasukan)
            .commit()
    }

}