package com.fillah.massiveaha.fragment

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fillah.massiveaha.Functions
import com.fillah.massiveaha.MainActivity
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentProfilBinding
import com.fillah.massiveaha.one.AboutAct
import com.fillah.massiveaha.one.KategoriFragment

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    private val functions = Functions()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProfilBinding.inflate(inflater, container, false)

        readUserData()

        binding.btnTentang.setOnClickListener{
            val intent = Intent(activity, AboutAct::class.java)
            startActivity(intent)
        }

        binding.btnKategori.setOnClickListener{
            val kategoriFragment = KategoriFragment()
            val transaction= parentFragmentManager
            transaction.beginTransaction()
                .replace(R.id.frame_layout, kategoriFragment)
                .addToBackStack("profil")
                .commit()
        }

        binding.btnLogout.setOnClickListener {
            functions.logout()
            //continue to activity
            val intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return binding.root
    }

    private fun readUserData(){

        //get user data
        functions.userData.get()
            .addOnSuccessListener {
                val username = it.data?.get("username").toString()
                val email = it.data?.get("email").toString()

                binding.tvUsername.text = username
                binding.tvEmail.text = email
            }
            .addOnFailureListener {
                println("failed to retrieve data. $it")
            }
    }
}