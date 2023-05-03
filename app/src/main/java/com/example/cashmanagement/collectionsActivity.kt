package com.example.cashmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.example.cashmanagement.fragments.Clients
import com.example.cashmanagement.fragments.CollHistory
import com.example.cashmanagement.fragments.TodayCollections
import com.example.cashmanagement.fragments.ViewPagerAd

class collectionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collections)

        setUpTabs()
    }

    private fun setUpTabs(){

        val adapter= ViewPagerAd(supportFragmentManager)

        adapter.addFragment(TodayCollections(), title= "Today Collections")
        adapter.addFragment(Clients(), title= "Clients")
        adapter.addFragment(CollHistory(), title= "History")

        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = adapter

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        tabs.tabMode = TabLayout.MODE_SCROLLABLE




      /*  tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                tab.view.setBackgroundColor(resources.getColor(R.color.selectedTabColor))
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                tab.view.setBackgroundColor(resources.getColor(android.R.color.transparent))
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // Nothing to do here
            }
        })*/


    }

}