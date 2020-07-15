package com.lyf.customcontrol.part2.draw01.rect

import android.content.Context
import android.graphics.*
import android.view.View

class MyRectView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 15f

        canvas?.drawRect(10f, 10f, 100f, 100f, paint) //直接构造

        val rectf = RectF(120f, 10f, 210f, 100f)
        canvas?.drawRect(rectf, paint) //使用RectF构造

        val rect = Rect(230, 10, 320, 100)
        canvas?.drawRect(rect, paint) //使用Rect构造

        val roundRectF = RectF(10f, 210f, 100f, 300f)
        canvas?.drawRoundRect(roundRectF, 20f, 10f, paint)
    }
}