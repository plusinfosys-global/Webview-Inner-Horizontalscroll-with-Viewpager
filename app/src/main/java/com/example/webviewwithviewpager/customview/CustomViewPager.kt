package com.example.webviewwithviewpager.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.viewpager.widget.ViewPager


class CustomViewPager : ViewPager {

    private var isPagingEnabled = true

    constructor(context: Context) : super(context) {
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
    }

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return this.isPagingEnabled && super.onTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {

        try {
            return this.isPagingEnabled && super.onInterceptTouchEvent(ev)
        } catch (exception: IllegalArgumentException) {
            exception.printStackTrace()
        }

        return false
    }

    override fun canScroll(v: View?, checkV: Boolean, dx: Int, x: Int, y: Int): Boolean {
        return this.isPagingEnabled && super.canScroll(v, checkV, dx, x, y)
    }

    fun setPagingEnabled(b: Boolean) {
        this.isPagingEnabled = b
    }

    fun getPagingStatus(): Boolean? {
        return isPagingEnabled
    }

    override fun removeView(view: View?) {
        super.removeView(view)
    }

}