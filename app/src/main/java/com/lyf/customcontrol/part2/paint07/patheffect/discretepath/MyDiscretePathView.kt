package com.lyf.customcontrol.part2.paint07.patheffect.discretepath

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DiscretePathEffect
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.main.generatePaint
import com.lyf.customcontrol.main.getPath

class MyDiscretePathView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = generatePaint(Color.GREEN, Paint.Style.STROKE, 5f)
        val path = getPath()

        //第一条原生path
        canvas?.drawPath(path, paint)

        //第二条path
        canvas?.translate(0f, 200f)
        paint.pathEffect = DiscretePathEffect(2f, 5f)
        canvas?.drawPath(path, paint)

        //第三条path
        canvas?.translate(0f, 200f)
        paint.pathEffect = DiscretePathEffect(6f, 5f)
        canvas?.drawPath(path, paint)

        //第四条path
        canvas?.translate(0f, 200f)
        paint.pathEffect = DiscretePathEffect(6f, 15f)
        canvas?.drawPath(path, paint)
    }
}