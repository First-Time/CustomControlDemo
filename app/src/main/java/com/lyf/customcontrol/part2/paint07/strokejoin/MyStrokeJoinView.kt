package com.lyf.customcontrol.part2.paint07.strokejoin

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class MyStrokeJoinView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        paint.color = Color.GREEN
        paint.strokeWidth = 40f
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE

        val path = Path()

        path.moveTo(100f, 100f)
        path.lineTo(450f, 100f)
        path.lineTo(550f, 300f)
        paint.strokeJoin = Paint.Join.MITER
        canvas?.drawPath(path, paint)

        path.moveTo(100f, 400f)
        path.lineTo(450f, 400f)
        path.lineTo(550f, 600f)
        paint.strokeJoin = Paint.Join.BEVEL
        canvas?.drawPath(path, paint)

        path.moveTo(100f, 700f)
        path.lineTo(450f, 700f)
        path.lineTo(550f, 900f)
        paint.strokeJoin = Paint.Join.ROUND
        canvas?.drawPath(path, paint)
    }
}