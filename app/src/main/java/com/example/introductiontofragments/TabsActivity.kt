package com.example.introductiontofragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import layout.MyPagerAdapter

class TabsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabs)

        val vpAdapter = MyPagerAdapter(supportFragmentManager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT)
        val viewPager: ViewPager = findViewById(R.id.viewPager)
        viewPager.adapter = vpAdapter

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.one_icon_foreground)
        tabLayout.getTabAt(0)!!.text = "TAB 1"
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.two_icon_foreground)
        tabLayout.getTabAt(1)!!.text = "TAB 2"
    }
}