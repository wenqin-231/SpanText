package com.wenqin.lib

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.view.View
import androidx.annotation.ColorInt

class TextSpan(private val text: String) {

    var bold: Boolean = false
    var textSize: Int? = null

    @ColorInt
    var textColor: Int? = null
    var underline: Boolean = false
    var clickListener: ((View) -> Unit)? = null

    fun toSpannableString(): SpannableString {
        return SpannableString(text).apply {
            textColor?.let {
                setSpan(ForegroundColorSpan(it))
            }
            textSize?.let {
                setSpan(AbsoluteSizeSpan(it, true))
            }
            if (bold) {
                setSpan(StyleSpan(Typeface.BOLD))
            }
            if (underline) {
                setSpan(UnderlineSpan())
            }
            clickListener?.let {
                setSpan(ColorClickSpan(it))
            }
        }
    }

    private fun SpannableString.setSpan(what: Any) {
        setSpan(what, 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}