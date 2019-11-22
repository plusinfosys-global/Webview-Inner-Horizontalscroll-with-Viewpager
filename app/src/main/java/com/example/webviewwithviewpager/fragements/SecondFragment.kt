package com.example.webviewwithviewpager.fragements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.webviewwithviewpager.R

class SecondFragment : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view: View? = inflater.inflate(R.layout.fragment_second, container, false);
        val webview = view!!.findViewById(R.id.Webview1) as WebView
        val settings = webview.getSettings()
        webview.setWebChromeClient(WebChromeClient())
        webview.setWebViewClient(WebViewClient())
        settings.setJavaScriptEnabled(true)
        webview.setScrollContainer(false)
        webview.setVerticalScrollBarEnabled(false)
        webview.setHorizontalScrollBarEnabled(false)
        settings.setBuiltInZoomControls(true)
        settings.setSupportZoom(true)
        settings.setDisplayZoomControls(false)
        settings.setLoadWithOverviewMode(true)
        settings.setUseWideViewPort(true)
        webview.loadUrl("https://www.google.com/search?q=kotlin")
        return view
    }
}