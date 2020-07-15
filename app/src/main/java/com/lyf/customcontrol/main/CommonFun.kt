package com.lyf.customcontrol.main

import android.graphics.Paint

fun generatePaint(color: Int, style: Paint.Style, width: Float): Paint {
    val paint = Paint()
    paint.color = color
    paint.style = style
    paint.strokeWidth = width
    return paint
}