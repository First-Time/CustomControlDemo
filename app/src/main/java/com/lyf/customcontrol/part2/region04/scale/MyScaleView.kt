package com.lyf.customcontrol.part2.region04.scale

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import com.lyf.customcontrol.main.generatePaint

class MyScaleView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint1 = generatePaint(Color.RED, Paint.Style.STROKE, 5f)
        val paint2 = generatePaint(Color.GREEN, Paint.Style.STROKE, 5f)

        val rect = Rect(100, 100, 400, 200)

        canvas?.drawRect(rect, paint1)

        canvas?.scale(0.5f, 0.5f, 100f, 100f)

//        canvas?.scale(0.5f, 0.5f)
//        canvas?.translate(100f, 100f)

        canvas?.drawRect(rect, paint2)
    }
}