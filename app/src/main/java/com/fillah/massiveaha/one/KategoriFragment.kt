package com.fillah.massiveaha.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.fillah.massiveaha.databinding.FragmentKategoriBinding

class KategoriFragment : Fragment() {

    private lateinit var _binding: FragmentKategoriBinding
    private val binding get() = _binding

    private var btnPengeluaran = true

    private val kategoriPengeluaran = KategoriPengeluaran()
    private val kategoriPemasukan = KategoriPemasukan()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentKategoriBinding.inflate(inflater, container, false)

        initialCondition()

        binding.btnPengeluaran.setOnClickListener{
            if (!btnPengeluaran){
                btnPengeluaran = true
                binding.btnPengeluaran.alpha = 1f
                binding.btnPemasukan.alpha = 0.4f

                parentFragmentManager.beginTransaction()
                    .replace(binding.kategoriContainer.id, kategoriPengeluaran)
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
                    .replace(binding.kategoriContainer.id, kategoriPemasukan)
                    .commit()
            }
        }

        binding.btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        parentFragmentManager.beginTransaction()
            .remove(kategoriPengeluaran)
            .remove(kategoriPemasukan)
            .commit()
        super.onDestroyView()
    }

    private fun initialCondition(){

        if (btnPengeluaran){
            btnPengeluaran = true
            parentFragmentManager.beginTransaction()
                .add(binding.kategoriContainer.id, kategoriPengeluaran)
                .commit()

            binding.btnPemasukan.alpha = 0.4f
        } else {
            btnPengeluaran = false
            parentFragmentManager.beginTransaction()
                .add(binding.kategoriContainer.id, kategoriPemasukan)
                .commit()

            binding.btnPengeluaran.alpha = 0.4f
        }



    }

}