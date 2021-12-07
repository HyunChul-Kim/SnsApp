package com.chul.presentation.utils

import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

class HorizontalItemTouchListener: RecyclerView.OnItemTouchListener {
    private var prevX = 0f
    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        when(e.action) {
            MotionEvent.ACTION_DOWN -> {
                prevX = e.x
            }
            MotionEvent.ACTION_MOVE -> {
                val direction = if(prevX - e.x < 0) -1 else 1
                if(rv.canScrollHorizontally(direction)) {
                    rv.parent.requestDisallowInterceptTouchEvent(true)
                }
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                prevX = 0f
            }
        }
        return false
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {

    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }
}