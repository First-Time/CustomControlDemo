package com.lyf.customcontrol.part2.bitmapshadow17.bitmapshadow

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.lyf.customcontrol.R

class MyExtractAlphaView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val mPaint = Paint()
    private val mBitmap = BitmapFactory.decodeResource(resources, R.drawable.img_money)
    private val mAlphaBitmap = mBitmap.extractAlpha()

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawBitmap(mBitmap, null, Rect(0, 0, 462, 363), mPaint)

        //绘制阴影
        mPaint.maskFilter = BlurMaskFilter(10f, BlurMaskFilter.Blur.NORMAL)
        mPaint.color = Color.RED
        canvas?.drawBitmap(mAlphaBitmap, null, Rect(10, 363 + 50 + 10, 462, 363 * 2), mPaint)
        mPaint.color = Color.GREEN
        canvas?.drawBitmap(mAlphaBitmap, null, Rect(10, (363 + 50) * 2 + 10, 462, 363 * 3), mPaint)

        //绘制原图像
        mPaint.maskFilter = null
        canvas?.drawBitmap(mBitmap, null, Rect(0, 363 + 50, 462, 363 * 2), mPaint)
        mPaint.color = Color.GREEN
        canvas?.drawBitmap(mBitmap, null, Rect(0, (363 + 50) * 2, 462, 363 * 3), mPaint)
    }
}