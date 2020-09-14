package com.lyf.customcontrol.part1.valueanimator06.customobject

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.BounceInterpolator

class MyPointView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private lateinit var valueAnimator: ValueAnimator
    private var mCurPoint: Point? = null

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mPaint.color = Color.RED
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (mCurPoint != null) {
            canvas?.drawCircle(400f, 400f, mCurPoint!!.radius.toFloat(), mPaint)
        }
    }

    fun doPointAnim() {
        valueAnimator = ValueAnimator.ofObject(PointEvaluator(), Point(20), Point(200))
        valueAnimator.duration = 2000
        valueAnimator.interpolator = BounceInterpolator()
        valueAnimator.addUpdateListener { animation ->
            val curPoint = animation.animatedValue as Point
            mCurPoint = curPoint
            invalidate()
        }
        valueAnimator.start()
    }

    fun cancelPointAnim() {
        valueAnimator.cancel()
    }
}