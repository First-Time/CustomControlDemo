package com.lyf.customcontrol.part2.region04.translate

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import com.lyf.customcontrol.main.generatePaint

class MyTranslateView(context: Context?) : View(context) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint1 = generatePaint(Color.RED, Paint.Style.STROKE, 3f)
        val paint2 = generatePaint(Color.GREEN, Paint.Style.STROKE, 3f)

        val rect = Rect(0, 0, 400, 220)

        canvas?.drawRect(rect, paint1)

        canvas?.translate(100f, 100f)
        canvas?.drawRect(rect, paint2)
    }

}