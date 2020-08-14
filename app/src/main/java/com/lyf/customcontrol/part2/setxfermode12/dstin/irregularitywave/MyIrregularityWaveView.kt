package com.lyf.customcontrol.part2.setxfermode12.dstin.irregularitywave

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.lyf.customcontrol.R

class MyIrregularityWaveView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    private val paint = Paint()
    private val bitmapSRC = BitmapFactory.decodeResource(resources, R.drawable.img_bg_irregularity)
    private val bitmapWidth = bitmapSRC.width
    private val bitmapHeight = bitmapSRC.height
    private val bitmapDST = BitmapFactory.decodeResource(resources, R.drawable.img_irregularity)
    private var dx = 0
    private var layerId = 0

    init {
        startAnim()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        //先画出背景原形
        canvas?.drawBitmap(bitmapSRC, null, Rect(0, 0, bitmapWidth, bitmapHeight), paint)
        layerId = canvas?.saveLayer(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            null,
            Canvas.ALL_SAVE_FLAG
        )!!

        canvas?.drawBitmap(
            bitmapDST,
            Rect(dx, 0, bitmapWidth + dx, bitmapHeight),
            Rect(0, 0, bitmapWidth, bitmapHeight),
            paint
        )
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)
        canvas?.drawBitmap(bitmapSRC, null, Rect(0, 0, bitmapWidth, bitmapHeight), paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
    }

    private fun startAnim() {
        val valueAnimator = ValueAnimator.ofInt(0, bitmapDST.width)
        valueAnimator.duration = 4000
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.repeatMode = ValueAnimator.RESTART
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.addUpdateListener {
            dx = it.animatedValue as Int
            postInvalidate()
        }
        valueAnimator.start()
    }
}