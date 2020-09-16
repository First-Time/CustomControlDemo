package com.lyf.customcontrol.part1.objectanimator07.customobjectanimator

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class MyPointView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private var mCurPoint = Point(100f)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)

        mPaint.color = Color.RED
        mPaint.isAntiAlias = true
        mPaint.style = Paint.Style.FILL
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawCircle(400f, 400f, mCurPoint!!.radius, mPaint)
    }

    fun getPointRadius(): Float {
        return 50f
    }

    fun setPointRadius(radius: Float) {
        mCurPoint!!.radius = radius
        invalidate()
    }
}