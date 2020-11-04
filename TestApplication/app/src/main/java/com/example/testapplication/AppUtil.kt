package com.example.testapplication

import android.content.Context
import android.util.DisplayMetrics

object AppUtil {

    fun isEmptyOrNullString(input: String?): Boolean {
        return !(input != null && !input.trim { it <= ' ' }.isEmpty())
    }

    fun dpToPx(context: Context, dp: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun pxToDp(context: Context, px: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        return Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
    }

    fun spToPx(context: Context, sp: Float): Float {
        val displayMetrics = context.resources.displayMetrics
        return sp * displayMetrics.scaledDensity
    }
}