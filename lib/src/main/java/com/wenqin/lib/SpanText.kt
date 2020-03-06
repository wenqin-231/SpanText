package com.wenqin.lib

import android.widget.TextView

fun TextView.setSpanText(callback: Builder.() -> Unit) {
    val builder = Builder()
    builder.apply(callback)
    text = builder.createBuilder()
}