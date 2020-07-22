package com.lyf.customcontrol.part2.pathquadto06.rquadto

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class MyRQuadraticView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

        val paint = Paint()
        paint.color = Color.BLUE
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 0f

        val path = Path()
        path.moveTo(100f, 300f)
//        path.quadTo(200f, 200f, 300f, 300f)
        path.rQuadTo(100f, -100f, 200f, 0f)
//        path.quadTo(400f, 400f, 500f, 300f)
        path.rQuadTo(100f, 100f, 200f, 0f)

        canvas?.drawPath(path, paint)
    }
}