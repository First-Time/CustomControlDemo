package com.lyf.customcontrol.part2.lineargradient19.twocolorgradient

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class MyLinearGradientView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.shader = LinearGradient(
            0f,
            height.toFloat() / 2,
            width.toFloat(),
            height.toFloat() / 2,
            0xffff0000.toInt(),
            0xff00ff00.toInt(),
            Shader.TileMode.REPEAT
        )
        canvas?.drawRect(Rect(0, 0, width, height), mPaint)
    }
}