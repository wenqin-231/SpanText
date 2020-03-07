package com.wenqin.lib

import android.text.SpannableStringBuilder

class Builder {

    private val spans = arrayListOf<TextSpan>()

    fun append(text: String, action: (TextSpan.() -> Unit)? = null) {
        val textSpan = TextSpan(text)
        action?.let { textSpan.apply(it) }
        spans.add(textSpan)
    }

    fun hasClickSpan(): Boolean = spans.find { it.clickListener != null } != null

    fun createStringBuilder(): SpannableStringBuilder {
        return SpannableStringBuilder().apply {
            spans.forEachIndexed { _, span ->
                append(span.toSpannableString())
            }
        }
    }
}
