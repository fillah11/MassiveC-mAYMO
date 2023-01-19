package com.fillah.massiveaha.one

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

                val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
                transaction.replace(binding.kategoriContainer.id, kategoriPengeluaran)
                transaction.commit()
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

                val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
                transaction.replace(binding.kategoriContainer.id, kategoriPemasukan)
                transaction.commit()
            }
        }

        return binding.root
    }

    private fun initialCondition(){

        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
        transaction.replace(binding.kategoriContainer.id, kategoriPengeluaran)
        transaction.commit()

        binding.btnPemasukan.alpha = 0.4f

    }

}