package com.lyf.customcontrol.part2.paint07.patheffect.composesumpath

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.main.generatePaint
import com.lyf.customcontrol.main.getPath

class MyComposeSumPathView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = generatePaint(Color.GREEN, Paint.Style.STROKE, 5f)
        val path = getPath()

        //画原始路径
        canvas?.drawPath(path, paint)

        //仅应用圆角特效的路径
        canvas?.translate(0f, 200f)
        val cornerPathEffect = CornerPathEffect(100f)
        paint.pathEffect = cornerPathEffect
        canvas?.drawPath(path, paint)

        //仅应用虚线特效的路径
        canvas?.translate(0f, 200f)
        val dashPathEffect = DashPathEffect(floatArrayOf(2f, 5f, 10f, 10f), 0f)
        paint.pathEffect = dashPathEffect
        canvas?.drawPath(path, paint)

        //利用ComposePathEffect先应用圆角特效，再应用虚线特效
        canvas?.translate(0f, 200f)
        paint.pathEffect = ComposePathEffect(dashPathEffect, cornerPathEffect)
        canvas?.drawPath(path, paint)

        //利用ComposePathEffect先应用虚线特效，再应用圆角特效
        canvas?.translate(0f, 200f)
        paint.pathEffect = ComposePathEffect(cornerPathEffect, dashPathEffect)
        canvas?.drawPath(path, paint)

        //利用SumPathEffect分别将圆角特效和虚线特效应用于原始路径，然后将生成的两条特效路径合并
        canvas?.translate(0f, 200f)
        paint.pathEffect = SumPathEffect(cornerPathEffect, dashPathEffect)
        canvas?.drawPath(path, paint)
        canvas?.drawPath(path, paint)

        //利用SumPathEffect分别将圆角特效和虚线特效应用于原始路径，然后将生成的两条特效路径合并
        canvas?.translate(0f, 200f)
        paint.pathEffect = SumPathEffect(dashPathEffect, cornerPathEffect)
        canvas?.drawPath(path, paint)

    }
}