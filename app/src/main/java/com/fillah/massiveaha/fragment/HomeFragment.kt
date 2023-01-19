package com.fillah.massiveaha.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fillah.massiveaha.databinding.FragmentHomeBinding
import com.fillah.massiveaha.one.TipsAct


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.btnTips.setOnClickListener {
            val intent = Intent(activity, TipsAct::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}