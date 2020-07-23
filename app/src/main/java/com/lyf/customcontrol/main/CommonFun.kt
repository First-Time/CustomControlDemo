package com.lyf.customcontrol.main

import android.graphics.Paint
import android.graphics.Path

/**
 * 生成paint
 */
fun generatePaint(color: Int, style: Paint.Style, width: Float): Paint {
    val paint = Paint()
    paint.color = color
    paint.style = style
    paint.strokeWidth = width
    return paint
}

/**
 * 生成path
 */
fun getPath(): Path {
    val path = Path()
    //定义路径的起点
    path.moveTo(0f, 0f)

    //定义路径的各个点
    for (i in 0..40) {
        path.lineTo(i * 35f, Math.random().toFloat() * 150)
    }
    return path
}