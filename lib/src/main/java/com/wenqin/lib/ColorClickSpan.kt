package com.wenqin.lib

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

class ColorClickSpan(private val clickListener: (View) -> Unit) : ClickableSpan() {

    override fun onClick(widget: View) {
        clickListener(widget)
    }

    override fun updateDrawState(ds: TextPaint) {
        // ignore
    }
}