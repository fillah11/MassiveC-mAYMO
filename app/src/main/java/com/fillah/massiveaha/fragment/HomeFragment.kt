package com.fillah.massiveaha.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentHomeBinding
import com.fillah.massiveaha.one.DompetTanpaTemplateFragment
import com.fillah.massiveaha.one.DompetTemplateFragment
import com.fillah.massiveaha.one.TipsAct
import kotlinx.android.synthetic.main.activity_main.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val functions = Functions()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        functions.userData.get()
            .addOnSuccessListener {
                val useTemplate = it.data?.get("template")

                if (useTemplate as Boolean){


                } else {
                    //kalo ga pake template mau apa


                }

                val username = "Halo, ${it.data?.get("username").toString()}"
                val aset = functions.formatRupiah(it.data?.get("aset").toString().toDouble())
                val pendapatan = "dari ${functions.formatRupiah(it.data?.get("pendapatan").toString().toDouble())}"

                binding.tvUsername.text = username
                binding.tvAset.text = aset
                binding.tvPendapatan.text = pendapatan
            }
            .addOnFailureListener {
                println("failed to retrieve data. $it")
            }

        binding.btnTips.setOnClickListener {
            val intent = Intent(activity, TipsAct::class.java)
            startActivity(intent)
        }

        return binding.root
    }

}