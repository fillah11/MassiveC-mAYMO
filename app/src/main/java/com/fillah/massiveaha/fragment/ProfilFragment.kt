package com.fillah.massiveaha.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.fillah.massiveaha.MainActivity
import com.fillah.massiveaha.R
import com.fillah.massiveaha.databinding.FragmentProfilBinding
import com.fillah.massiveaha.one.AboutAct
import com.fillah.massiveaha.one.KategoriFragment
import com.fillah.massiveaha.one.LoginAct
import com.google.firebase.auth.FirebaseAuth

class ProfilFragment : Fragment() {

    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    private val auth = FirebaseAuth.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment

        _binding = FragmentProfilBinding.inflate(inflater, container, false)

        binding.btnTentang.setOnClickListener{
            val intent = Intent(activity, AboutAct::class.java)
            startActivity(intent)
        }

        binding.btnKategori.setOnClickListener{
            val kategoriFragment = KategoriFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
            transaction.replace(R.id.frame_layout, kategoriFragment)
            transaction.addToBackStack("profil")
            transaction.commit()
        }

        binding.btnLogout.setOnClickListener {
            auth.signOut()
            //continue to activity
            val intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return binding.root
    }
}