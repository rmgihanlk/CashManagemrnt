package com.example.cashmanagement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.example.cashmanagement.fragments.Reminders2
import com.example.cashmanagement.fragments.Clients2
import com.example.cashmanagement.fragments.ViewPagerAd

class OverdueInvoicesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_overdue_invoices)

        setUpTabs()
    }

    private fun setUpTabs(){

        val adapter= ViewPagerAd(supportFragmentManager)

        adapter.addFragment(Clients2(), title= "Clients")
        adapter.addFragment(Reminders2(), title= "Reminders")

        val viewPager: ViewPager = findViewById(R.id.viewPager4)
        viewPager.adapter = adapter

        val tabs: TabLayout = findViewById(R.id.tabs4)
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