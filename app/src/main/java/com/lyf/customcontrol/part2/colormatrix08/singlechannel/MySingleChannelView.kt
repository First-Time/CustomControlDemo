package com.lyf.customcontrol.part2.colormatrix08.singlechannel

import android.content.Context
import android.graphics.Canvas
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MySingleChannelView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        paint.isAntiAlias = true
        paint.colorFilter = null
        paint.setARGB(255, 200, 100, 100)
//        paint.setARGB(255, 255, 255, 255)

        //绘制原始位图
        canvas?.drawRect(0f, 0f, 500f, 600f, paint)

        canvas?.translate(550f, 0f)

        //生成色彩矩阵
        val colorMatrix = ColorMatrix(
            floatArrayOf(
                0f, 0f, 0f, 0f, 0f,
                0f, 0f, 0f, 0f, 0f,
                0f, 0f, 1f, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            )
        )
        paint.colorFilter = ColorMatrixColorFilter(colorMatrix)

        canvas?.drawRect(0f, 0f, 500f, 600f, paint)
    }
}