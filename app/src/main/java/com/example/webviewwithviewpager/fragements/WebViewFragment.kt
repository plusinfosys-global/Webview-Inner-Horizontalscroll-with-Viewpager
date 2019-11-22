package com.example.webviewwithviewpager.fragements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.webviewwithviewpager.MainActivity
import com.example.webviewwithviewpager.R
import com.example.webviewwithviewpager.customview.CustomViewPager
import com.example.webviewwithviewpager.customview.CustomWebView

class WebViewFragment : Fragment() {

    internal var sectionNumber: Int = 0
    internal lateinit var activity: MainActivity
    internal lateinit var viewpager: CustomViewPager
    internal lateinit var parentActivity: MainActivity

    fun setActivity(activity: MainActivity) {
        this.activity = activity
    }

    fun setPager(viewpager: CustomViewPager) {
        this.viewpager = viewpager
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //val arguments = arguments
      //  sectionNumber = arguments!!.getInt(ARG_SECTION_NUMBER)

        parentActivity = getActivity() as MainActivity
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)
        val webView = rootView.findViewById(R.id.webView) as CustomWebView
        webView.setFragment(this)

        val settings = webView.getSettings()
        webView.setWebChromeClient(WebChromeClient())
        webView.setWebViewClient(WebViewClient())
        settings.setJavaScriptEnabled(true)
        webView.setScrollContainer(false)
        webView.setVerticalScrollBarEnabled(false)
        webView.setHorizontalScrollBarEnabled(false)
        settings.setBuiltInZoomControls(true)
        settings.setSupportZoom(true)
        settings.setDisplayZoomControls(false)
        settings.setLoadWithOverviewMode(true)
        settings.setUseWideViewPort(true)
        webView.loadUrl("https://www.google.com/search?q=android")
        return rootView
    }


    fun setViewPager(b: Boolean) {
        parentActivity.setViewPagerStatus(b)
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(sectionNumber: Int): WebViewFragment {
            val fragment = WebViewFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
}