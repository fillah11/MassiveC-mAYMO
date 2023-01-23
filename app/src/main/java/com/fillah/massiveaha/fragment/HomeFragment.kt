package com.fillah.massiveaha.fragment

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.databinding.FragmentHomeBinding
import com.fillah.massiveaha.one.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val functions = Functions()

    private val dompetTemplateFragment = DompetTemplateFragment()
    private val dompetTanpaTemplateFragment = DompetTanpaTemplateFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        readUserData()

        binding.btnTips.setOnClickListener {
            val intent = Intent(activity, TipsAct::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    private fun readUserData() {
        functions.userData.get()
            .addOnSuccessListener {
                val useTemplate = it.data?.get("template")

                if (useTemplate as Boolean){
                    //kalo pake template
                    parentFragmentManager.beginTransaction()
                        .add(binding.FrameDompet.id ,dompetTemplateFragment)
                        .commit()
                } else {
                    //kalo ga pake template mau apa
                    parentFragmentManager.beginTransaction()
                        .add(binding.FrameDompet.id ,dompetTanpaTemplateFragment)
                        .commit()
                }

                val username = "Halo, ${it.data?.get("username").toString()}"
                binding.tvUsername.text = username

            }
            .addOnFailureListener {
                println("failed to retrieve data. $it")
            }
    }

    override fun onDestroyView() {
        parentFragmentManager.beginTransaction()
            .remove(dompetTemplateFragment)
            .remove(dompetTanpaTemplateFragment)
            .commit()
        super.onDestroyView()
    }
}