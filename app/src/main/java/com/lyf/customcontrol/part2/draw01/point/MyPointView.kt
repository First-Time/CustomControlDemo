package com.lyf.customcontrol.part2.draw01.point

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class MyPointView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 0f
        paint.strokeCap = Paint.Cap.SQUARE

        /*canvas?.drawPoint(100f, 100f, paint)

        paint.strokeCap = Paint.Cap.ROUND
        canvas?.drawPoint(200f, 100f, paint)*/

        val pts = floatArrayOf(10f, 10f, 100f, 100f, 200f, 200f, 400f, 400f)
        canvas?.drawPoints(pts, 2, 4, paint)
    }
}