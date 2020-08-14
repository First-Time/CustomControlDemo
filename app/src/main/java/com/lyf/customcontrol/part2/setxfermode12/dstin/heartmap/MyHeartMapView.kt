package com.lyf.customcontrol.part2.setxfermode12.dstin.heartmap

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.lyf.customcontrol.R

class MyHeartMapView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    private val paint = Paint()
    private val bitmapDST = BitmapFactory.decodeResource(resources, R.drawable.img_money)
    private val bitmapWidth = resources.displayMetrics.widthPixels
    private val bitmapHeight = bitmapWidth * bitmapDST.height / bitmapDST.width
    private var dx = 0

    private val bitmapSRC = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
    private var layerId = 0

    init {
        paint.color = Color.BLACK
        paint.style = Paint.Style.FILL

        startAnim()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val c = Canvas(bitmapSRC)
        c.drawColor(Color.BLACK, PorterDuff.Mode.CLEAR)
        c.drawRect(
            bitmapWidth.toFloat() - dx,
            0f,
            bitmapWidth.toFloat(),
            bitmapHeight.toFloat(),
            paint
        )

        layerId = canvas?.saveLayer(
            0f,
            0f,
            width.toFloat(),
            height.toFloat(),
            null,
            Canvas.ALL_SAVE_FLAG
        )!!

        canvas?.drawBitmap(bitmapDST, null, Rect(0, 0, bitmapWidth, bitmapHeight), paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_IN)

        canvas?.drawBitmap(bitmapSRC, 0f, 0f, paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
    }

    private fun startAnim() {
        val valueAnimator = ValueAnimator.ofInt(1, bitmapWidth)
        valueAnimator.duration = 10000
        valueAnimator.repeatMode = ValueAnimator.RESTART
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.addUpdateListener {
            dx = it.animatedValue as Int
            postInvalidate()
        }
        valueAnimator.start()
    }
}