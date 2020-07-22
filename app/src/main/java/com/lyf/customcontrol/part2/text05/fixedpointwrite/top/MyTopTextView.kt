package com.lyf.customcontrol.part2.text05.fixedpointwrite.top

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyTopTextView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val text = "燕窝，金丝燕"
        val top = 200f
        val baselineX = 0f

        val paint = Paint()
        paint.textSize = 120f
        paint.textAlign = Paint.Align.LEFT
        paint.strokeWidth = 5f

        //画top线
        paint.color = Color.YELLOW
        canvas?.drawLine(baselineX, top, 3000f, top, paint)

        //计算出baseline的位置
        val fontMetrics = paint.fontMetrics
        val baselineY = top - fontMetrics.top

        //画基线
        paint.color = Color.RED
        canvas?.drawLine(baselineX, baselineY, 3000f, baselineY, paint)

        //画文字
        paint.color = Color.GREEN
        canvas?.drawText(text, baselineX, baselineY, paint)
    }
}