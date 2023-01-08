package com.fillah.massiveaha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.fillah.massiveaha.fragment.HomeFragment
import com.fillah.massiveaha.fragment.KalenderFragment
import com.fillah.massiveaha.fragment.GrafikFragment
import com.fillah.massiveaha.fragment.ProfilFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val kalenderFragment = KalenderFragment()
    private val grafikFragment = GrafikFragment()
    private val profileFragment = ProfilFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)
        supportActionBar?.hide()

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.home -> replaceFragment(homeFragment)
                R.id.kalender -> replaceFragment(kalenderFragment)
                R.id.grafik -> replaceFragment(grafikFragment)
                R.id.profil -> replaceFragment(profileFragment)
            }
            true
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
