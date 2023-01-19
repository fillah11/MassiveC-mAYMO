package com.fillah.massiveaha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fillah.massiveaha.fragment.HomeFragment
import com.fillah.massiveaha.fragment.KalenderFragment
import com.fillah.massiveaha.fragment.GrafikFragment
import com.fillah.massiveaha.fragment.ProfilFragment
import com.fillah.massiveaha.one.LoginAct
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val kalenderFragment = KalenderFragment()
    private val grafikFragment = GrafikFragment()
    private val profileFragment = ProfilFragment()

    private val auth = FirebaseAuth.getInstance()
//    private val firestore = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkCredential()

        replaceFragment(homeFragment)
        supportActionBar?.hide()

        bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.kalender -> replaceFragment(kalenderFragment)
                R.id.grafik -> replaceFragment(grafikFragment)
                R.id.profil -> replaceFragment(profileFragment)
            }
            true
        }

    }

    private fun checkCredential() {
        val user = auth.currentUser
        if (user != null) {
            //user is logged in
        } else {
            //user is not logged in
            startActivity(Intent(this, LoginAct::class.java))
            finish()
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_layout, fragment)
            transaction.commit()
        }
    }
}
