package com.example.webviewwithviewpager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.webviewwithviewpager.MainActivity
import com.example.webviewwithviewpager.customview.CustomViewPager
import com.example.webviewwithviewpager.fragements.WebViewFragment

class MyFragmentPagerAdapter(manager: FragmentManager, internal var viewPager: CustomViewPager,
                             internal var activity: MainActivity
) :
    FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList: ArrayList<Fragment> = ArrayList()

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment) {
        mFragmentList.add(fragment)
    }
    override fun getItem(position: Int): Fragment {
        val fragment = mFragmentList.get(position)//WebViewFragment.newInstance(position + 1)
        if(fragment is WebViewFragment) {
            fragment.setActivity(activity)
        }
        return fragment
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Page "+position
    }
}
