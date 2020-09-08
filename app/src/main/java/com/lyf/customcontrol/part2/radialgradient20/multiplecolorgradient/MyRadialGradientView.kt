package com.lyf.customcontrol.part2.radialgradient20.multiplecolorgradient

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

class MyRadialGradientView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private lateinit var mRadialGradient: RadialGradient

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        val colors = intArrayOf(
            0xffff0000.toInt(), 0xff00ff00.toInt(),
            0xff0000ff.toInt(), 0xffffff00.toInt()
        )
        val pos = floatArrayOf(0f, 0.2f, 0.5f, 1f)

        mRadialGradient = RadialGradient(
            width.toFloat() / 2,
            height.toFloat() / 2,
            100f,
            colors,
            pos,
            Shader.TileMode.CLAMP
        )

        postInvalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.shader = mRadialGradient

//        canvas?.drawCircle(width.toFloat() / 2, height.toFloat() / 2, 100f, mPaint)

        //TileMode.CLAMP——边缘填充
        canvas?.drawRect(0f, 0f, width.toFloat(), height.toFloat(), mPaint)
    }
}