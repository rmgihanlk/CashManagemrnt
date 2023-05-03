package com.example.cashmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.example.cashmanagement.fragments.OutstandingHistory
import com.example.cashmanagement.fragments.Reminders
import com.example.cashmanagement.fragments.Invoices
import com.example.cashmanagement.fragments.ViewPagerAd

class OutstandClientActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outstand_client)

        setUpTabs()
    }

    private fun setUpTabs(){

        val adapter= ViewPagerAd(supportFragmentManager)

        adapter.addFragment(Invoices(), title= "Invoices")
        adapter.addFragment(Reminders(), title= "Reminders")
        adapter.addFragment(OutstandingHistory(), title= "Outstanding History")

        val viewPager: ViewPager = findViewById(R.id.viewPager3)
        viewPager.adapter = adapter

        val tabs: TabLayout = findViewById(R.id.tabs3)
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