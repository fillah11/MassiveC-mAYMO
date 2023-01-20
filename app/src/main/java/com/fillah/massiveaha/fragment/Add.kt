package com.fillah.massiveaha.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.fillah.massiveaha.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class Add : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val tabLayout = findViewById<TabLayout>(R.id.tabsLayout)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager2)



        supportActionBar?.apply {
            title = "Add"
            subtitle = "MayMo"
        }

        val listFragment = arrayListOf(
            Pemasukan(),
            Pengeluaran()
        )

        viewPager.adapter =
            ViewPager(listFragment,supportFragmentManager,lifecycle)

        TabLayoutMediator(tabLayout,viewPager){
                tab,position ->
            when(position){
                0 -> {
                    tab.text = "Pemasukan"
                }
                1 -> {
                    tab.text = "Pengeluaran"
                }
            }
        }.attach()
    }
}