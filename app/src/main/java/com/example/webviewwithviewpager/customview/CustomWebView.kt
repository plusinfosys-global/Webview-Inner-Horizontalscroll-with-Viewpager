package com.example.webviewwithviewpager.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.webkit.WebView
import com.example.webviewwithviewpager.fragements.WebViewFragment

class CustomWebView : WebView {

    constructor(context: Context): super(context){
        webView= this
    }

    constructor(context: Context, attrs: AttributeSet): super(context, attrs) {
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int):   super(context, attrs, defStyleAttr){

    }

    private val x: Float? = null
    private val y: Float? = null
    private val prevX: Float? = null
    val prevY: Float? = null
    private val link: String? = null
    val image: String? = null
    internal lateinit var webView: CustomWebView
    internal lateinit var webViewFragment: WebViewFragment

    fun setFragment(webViewFragment: WebViewFragment) {
        this.webViewFragment = webViewFragment
    }

    override fun onOverScrolled(scrollX: Int, scrollY: Int, clampedX: Boolean, clampedY: Boolean) {
        //Enables ViewPager when scroll reaches end.
        webViewFragment.setViewPager(true)
        super.onOverScrolled(scrollX, scrollY, clampedX, clampedY)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event)

        //disables ViewPager when user presses down
        if (event.action == MotionEvent.ACTION_DOWN) {
            webViewFragment.setViewPager(false)
            return true
        }

        return true


    }
}