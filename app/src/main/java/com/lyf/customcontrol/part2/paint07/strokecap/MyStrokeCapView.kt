package com.lyf.customcontrol.part2.paint07.strokecap

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyStrokeCapView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.GREEN
        paint.strokeWidth = 80f
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE

        paint.strokeCap = Paint.Cap.BUTT
        canvas?.drawLine(100f, 200f, 400f, 200f, paint)

        paint.strokeCap = Paint.Cap.SQUARE
        canvas?.drawLine(100f, 400f, 400f, 400f, paint)

        paint.strokeCap = Paint.Cap.ROUND
        canvas?.drawLine(100f, 600f, 400f, 600f, paint)

        paint.reset()
        paint.color = Color.RED
        paint.strokeWidth = 2f
        canvas?.drawLine(100f, 50f, 100f, 750f, paint)
    }
}