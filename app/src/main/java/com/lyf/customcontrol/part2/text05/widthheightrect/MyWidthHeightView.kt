package com.lyf.customcontrol.part2.text05.widthheightrect

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyWidthHeightView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.textAlign = Paint.Align.LEFT
        paint.textSize = 120f

        val baselineX = 0f
        val baselineY = 200f
        val text = "蒙娜丽莎的眼泪"

        //画基线
        canvas?.drawLine(baselineX, baselineY, 3000f, baselineY, paint)

        val fontMetrics = paint.fontMetrics

        //获取文字top线Y坐标
        val top = baselineY + fontMetrics.top

        //获取文字bottom线Y坐标
        val bottom = baselineY + fontMetrics.bottom

        //获取文字高度
        val height = bottom - top
        //获取文字宽度
        val width = paint.measureText(text)

        println("height = $height width = $width")

        paint.color = Color.GREEN
        //画文字所占用的矩形区域
        canvas?.drawRect(RectF(baselineX, top, baselineX + width, top + height), paint)

        //获取文字的最小矩形，此时得到的矩形是以坐标[0,0]为基线
        val minRect = Rect()
        paint.getTextBounds(text, 0, text.length, minRect)
        println(minRect.toShortString())

        minRect.top += baselineY.toInt()
        minRect.bottom += baselineY.toInt()
        println("minTop = ${minRect.top} minBottom = ${minRect.bottom}")

        paint.color = Color.RED
        //画文字所占用的最小矩形区域
        canvas?.drawRect(minRect, paint)

        paint.color = Color.BLACK
        canvas?.drawText(text, baselineX, baselineY, paint)
    }
}