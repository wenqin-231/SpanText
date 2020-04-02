package com.wenqin.lib

import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.style.*
import android.view.View
import androidx.annotation.ColorInt

class TextSpan(private val text: String) {

    var textSize: Int? = null
    @ColorInt
    var textColor: Int? = null
    @ColorInt
    var backgroundColor: Int? = null

    var bold: Boolean = false
    var italic: Boolean = false
    var underline: Boolean = false
    var strikethrough: Boolean = false
    var subscript: Boolean = false
    var superscript: Boolean = false

    var clickListener: ((View) -> Unit)? = null

    fun toSpannableString(): SpannableString {
        return SpannableString(text).apply {
            textColor?.also {
                setSpan(ForegroundColorSpan(it))
            }
            textSize?.also {
                setSpan(AbsoluteSizeSpan(it, true))
            }
            backgroundColor?.also {
                setSpan(BackgroundColorSpan(it))
            }
            setSpan(StyleSpan(absoluteSizeSpan(bold, italic)))
            if (underline) {
                setSpan(UnderlineSpan())
            }
            if (strikethrough) {
                setSpan(StrikethroughSpan())
            }
            if (subscript) {
                setSpan(SubscriptSpan())
            }
            if (superscript) {
                setSpan(SuperscriptSpan())
            }
            clickListener?.let {
                setSpan(ColorClickSpan(it))
            }
        }
    }

    private fun SpannableString.setSpan(what: Any) {
        setSpan(what, 0, text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }

    private fun absoluteSizeSpan(bold: Boolean, italic: Boolean) =
        when {
            bold && italic -> Typeface.BOLD_ITALIC
            bold -> Typeface.BOLD
            italic -> Typeface.ITALIC
            else -> Typeface.NORMAL
        }
}