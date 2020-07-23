package com.lyf.customcontrol.part2.paint07.patheffect.cornerpath

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.main.generatePaint

class MyCornerPathView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = generatePaint(Color.GREEN, Paint.Style.STROKE, 5f)
        val path = Path()
        path.moveTo(100f, 600f)
        path.lineTo(400f, 100f)
        path.lineTo(700f, 900f)

        canvas?.drawPath(path, paint)

        paint.color = Color.RED
        paint.pathEffect = CornerPathEffect(100f)
        canvas?.drawPath(path, paint)

        paint.color = Color.YELLOW
        paint.pathEffect = CornerPathEffect(200f)
        canvas?.drawPath(path, paint)
    }
}