package com.lyf.customcontrol.part2.text05.fixedpointwrite.center

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyCenterTextView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val text = "燕窝，金丝燕"
        val center = 200f
        val baselineX = 0f

        val paint = Paint()
        paint.textSize = 120f
        paint.textAlign = Paint.Align.LEFT
        paint.strokeWidth = 5f

        //画center线
        paint.color = Color.YELLOW
        canvas?.drawLine(baselineX, center, 3000f, center, paint)

        //计算出baseline位置
        //A = C = center - top = bottom - center = (bottom - top) / 2
        //bottom = baselineY + fontMetrics.bottom
        //top = baselineY + fontMetrics.top
        //A = C = (fontMetrics.bottom - fontMetrics.top) / 2
        //B = C - (bottom - baselineY) = (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom
        //baselineY = center + B = center + (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom

        val fontMetrics = paint.fontMetrics
        val baselineY = center + (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom
        paint.color = Color.RED
        canvas?.drawLine(baselineX, baselineY, 3000f, baselineY, paint)

        //画文字
        paint.color = Color.GREEN
        canvas?.drawText(text, baselineX, baselineY, paint)
    }
}