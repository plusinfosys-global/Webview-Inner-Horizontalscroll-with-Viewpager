package com.example.webviewwithviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.webviewwithviewpager.adapter.MyFragmentPagerAdapter
import com.example.webviewwithviewpager.customview.CustomViewPager
import com.example.webviewwithviewpager.fragements.SecondFragment
import com.example.webviewwithviewpager.fragements.SimpleFragment
import com.example.webviewwithviewpager.fragements.WebViewFragment

class MainActivity : AppCompatActivity(), requestInterface {
    override fun setViewPagerStatus(b: Boolean?) {
        horzontalViewPager.setPagingEnabled(b!!)
    }

    lateinit var horzontalViewPager: CustomViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        horzontalViewPager = findViewById(R.id.viewPager)
        val mSectionsPagerAdapter = MyFragmentPagerAdapter(
            supportFragmentManager,
            horzontalViewPager,
            this
        )
        mSectionsPagerAdapter.addFragment(WebViewFragment())
        mSectionsPagerAdapter.addFragment(SecondFragment())
        mSectionsPagerAdapter.addFragment(SimpleFragment())

        horzontalViewPager.setAdapter(mSectionsPagerAdapter)
        horzontalViewPager.setOffscreenPageLimit(2)
    }
}



