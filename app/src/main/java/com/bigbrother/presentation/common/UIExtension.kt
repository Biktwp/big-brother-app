package com.bigbrother.presentation.common

import android.content.res.Resources
import android.view.View
import androidx.core.graphics.ColorUtils
import com.bigbrother.R


fun View.overlay01() {
    setBackgroundColor(getOverlayColor(0.05F,resources))
}

fun View.overlay02() {
    setBackgroundColor(getOverlayColor(0.07F,resources))
}

fun View.overlay03() {
    setBackgroundColor(getOverlayColor(0.08F,resources))
}

fun View.overlay04() {
    setBackgroundColor(getOverlayColor(0.09F,resources))
}

fun View.overlay06() {
    setBackgroundColor(getOverlayColor(0.11F,resources))
}

fun View.overlay08() {
    setBackgroundColor(getOverlayColor(0.12F,resources))
}

fun View.overlay12() {
    setBackgroundColor(getOverlayColor(0.14F,resources))
}

fun View.overlay16() {
    setBackgroundColor(getOverlayColor(0.15F,resources))
}

fun View.overlay24() {
    setBackgroundColor(getOverlayColor(0.16F,resources))
}

private fun getOverlayColor(alpha: Float, resources: Resources) =
    ColorUtils.blendARGB(
        resources.getColor(R.color.black, null),
        resources.getColor(R.color.white, null),
        alpha
    )
