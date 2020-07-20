package com.lyf.customcontrol.part2.region04.skew

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import com.lyf.customcontrol.main.generatePaint

class MySkewView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint1 = generatePaint(Color.RED, Paint.Style.STROKE, 5f)
        val paint2 = generatePaint(Color.GREEN, Paint.Style.STROKE, 5f)

        val rect = Rect(100, 100, 500, 300)
        canvas?.drawRect(rect, paint1)

        canvas?.skew(1.732f, 0f)
        canvas?.drawRect(rect, paint2)
    }
}