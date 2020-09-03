package com.lyf.customcontrol.part2.shadowglow16.setshadowlayer

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyShadowLayerView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private val mBitmap = BitmapFactory.decodeResource(resources, R.drawable.img_dog)
    private var mSetShadow = true
    private var mRadius = 1f
    private var mDx = 10f
    private var mDy = 10f

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mPaint.color = Color.GREEN
        mPaint.textSize = 25f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (mSetShadow) {
            mPaint.setShadowLayer(mRadius, mDx, mDy, Color.CYAN)
        } else {
            mPaint.clearShadowLayer()
        }
        canvas?.drawText("昨夜西风凋碧树", 100f, 100f, mPaint)
        canvas?.drawCircle(200f, 200f, 50f, mPaint)
        canvas?.drawBitmap(mBitmap, null, Rect(200, 300, 500, 600), mPaint)
    }

    fun changeRadius() {
        mRadius++
        postInvalidate()
    }

    fun changeDx() {
        mDx += 5f
        postInvalidate()
    }

    fun changeDy() {
        mDy += 5f
        postInvalidate()
    }

    fun clearShadow() {
        mSetShadow = false
        postInvalidate()
    }

    fun showShadow() {
        mSetShadow = true
        postInvalidate()
    }
}