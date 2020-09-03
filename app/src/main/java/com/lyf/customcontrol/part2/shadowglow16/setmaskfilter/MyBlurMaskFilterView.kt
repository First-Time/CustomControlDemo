package com.lyf.customcontrol.part2.shadowglow16.setmaskfilter

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyBlurMaskFilterView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()

    init {
        mPaint.color = Color.RED
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        mPaint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
        canvas?.drawCircle(200f, 200f, 100f, mPaint)

        mPaint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)
        canvas?.drawCircle(200f, 500f, 100f, mPaint)

        mPaint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
        canvas?.drawCircle(200f, 800f, 100f, mPaint)

        mPaint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
        canvas?.drawCircle(200f, 1100f, 100f, mPaint)
    }
}