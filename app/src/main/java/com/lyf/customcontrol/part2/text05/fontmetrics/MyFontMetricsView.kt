package com.lyf.customcontrol.part2.text05.fontmetrics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyFontMetricsView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.GREEN
        paint.style = Paint.Style.FILL
        paint.textSize = 120f
        paint.textAlign = Paint.Align.LEFT

        val baselineX = 0f
        val baselineY = 200f

        canvas?.drawText("恼人的秋风", baselineX, baselineY, paint)

        val fontMetrics = paint.fontMetrics

        val top = baselineY + fontMetrics.top
        val ascent = baselineY + fontMetrics.ascent
        val descent = baselineY + fontMetrics.descent
        val bottom = baselineY + fontMetrics.bottom

        println("top = $top")
        println("ascent = $ascent")
        println("descent = $descent")
        println("bottom = $bottom")

        //画基线
        paint.color = Color.RED
        canvas?.drawLine(baselineX, baselineY, 3000f, baselineY, paint)

        //画top线
        paint.color = Color.BLUE
        canvas?.drawLine(baselineX, top, 3000f, top, paint)

        //画ascent线
        paint.color = Color.GREEN
        canvas?.drawLine(baselineX, ascent, 3000f, ascent, paint)

        //画descent线
        paint.color = Color.YELLOW
        canvas?.drawLine(baselineX, descent, 3000f, descent, paint)

        //画bottom线
        paint.color = Color.RED
        canvas?.drawLine(baselineX, bottom, 3000f, bottom, paint)
    }
}