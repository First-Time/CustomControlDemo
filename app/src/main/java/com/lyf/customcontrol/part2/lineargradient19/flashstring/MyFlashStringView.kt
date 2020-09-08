package com.lyf.customcontrol.part2.lineargradient19.flashstring

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class MyFlashStringView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    AppCompatTextView(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = paint
    private lateinit var mLinearGradient: LinearGradient
    private lateinit var mValueAnimator: ValueAnimator
    private var phase = 0f

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        mValueAnimator = ValueAnimator.ofFloat(0f, 2f * measuredWidth)
        mValueAnimator.repeatMode = ValueAnimator.RESTART
        mValueAnimator.repeatCount = ValueAnimator.INFINITE
        mValueAnimator.duration = 3000
        mValueAnimator.addUpdateListener {
            phase = it.animatedValue as Float
            postInvalidate()
        }
        mValueAnimator.start()

        //绘制渐变文本
        val colors = intArrayOf(currentTextColor, 0xff00ff00.toInt(), currentTextColor)
        val pos = floatArrayOf(0f, 0.5f, 1.0f)

        mLinearGradient = LinearGradient(
            -measuredWidth.toFloat(),
            0f,
            0f,
            0f,
            colors,
            pos,
            Shader.TileMode.CLAMP
        )
    }

    override fun onDraw(canvas: Canvas?) {
        val matrix = Matrix()
        matrix.setTranslate(phase, 0f)
        mLinearGradient.setLocalMatrix(matrix)
        mPaint.shader = mLinearGradient

        super.onDraw(canvas)
    }
}