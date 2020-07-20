package com.lyf.customcontrol.part2.region04.rotate

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import com.lyf.customcontrol.main.generatePaint

class MyRotateView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint1 = generatePaint(Color.RED, Paint.Style.STROKE, 5f)
        val paint2 = generatePaint(Color.GREEN, Paint.Style.STROKE, 5f)

        val rect = Rect(300, 10, 500, 100)
        canvas?.drawRect(rect, paint1)

        canvas?.rotate(30f)

        canvas?.drawRect(rect, paint2)
    }
}