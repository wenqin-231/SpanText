package com.wenqin.lib

import android.graphics.Color
import android.text.method.LinkMovementMethod
import android.widget.TextView

fun TextView.setSpanText(callback: Builder.() -> Unit) {
    val builder = Builder()
    builder.apply(callback)
    if (builder.hasClickSpan()) {
        movementMethod = LinkMovementMethod.getInstance()
        highlightColor = Color.TRANSPARENT
    }
    text = builder.createStringBuilder()
}