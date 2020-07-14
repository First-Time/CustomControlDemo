package com.lyf.customcontrol.draw01.arc

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.view.View

class MyArcView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
//        paint.style = Paint.Style.STROKE
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 5f

        val rectf = RectF(100f, 10f, 300f, 100f)
        canvas?.drawArc(rectf, 0f, 90f, true, paint)

        val rectf2 = RectF(400f, 10f, 600f, 100f)
        canvas?.drawArc(rectf2, 0f, 90f, false, paint)
    }
}