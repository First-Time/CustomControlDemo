package com.lyf.customcontrol.part2.text05.fourlineandbase

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyBlogDrawView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val baselineX = 0f
        val baselineY = 200f

        val paint = Paint()
        paint.color = Color.RED
        canvas?.drawLine(baselineX, baselineY, 3000f, baselineY, paint)

        paint.color = Color.GREEN
        paint.textSize = 120f
//        paint.textAlign = Paint.Align.LEFT
        paint.textAlign = Paint.Align.CENTER
//        paint.textAlign = Paint.Align.RIGHT

//        canvas?.drawText("恼人的秋风", baselineX, baselineY, paint)
        canvas?.drawText("A", baselineX, baselineY, paint)
    }
}