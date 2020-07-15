package com.lyf.customcontrol.part2.draw01.oval

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class MyOvalView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 5f

        val rectf = RectF(100f, 100f, 300f, 200f)
        canvas?.drawRect(rectf, paint)

        paint.color = Color.GREEN
        canvas?.drawOval(rectf, paint)
    }
}