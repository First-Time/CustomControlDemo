package com.lyf.customcontrol.part2.setxfermode12.dstin.circlewave

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.lyf.customcontrol.R

class MyCircleWaveView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null, 0)

    private val paint = Paint()
    private val path = Path()
    private val mItemWaveLength = 1000f
    private var dx = 0f
    private val bitmapSRC = BitmapFactory.decodeResource(resources, R.drawable.img_money)
    private val bitmapWidth = resources.displayMetrics.widthPixels
    private val bitmapHeight = bitmapWidth * bitmapSRC.height / bitmapSRC.width
    private val bitmapDST =
        Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
    private var layerId = 0

    init {
        paint.color = Color.GREEN
        paint.style = Paint.Style.FILL_AND_STROKE

        startAnim()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        generateWavePath()

        //双缓冲
        //先清空bitmap上的图像，然后再画上path
        val c = Canvas(bitmapDST)
        c.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR)
        c.drawPath(path, paint)

        canvas?.drawBitmap(bitmapSRC, null, Rect(0, 0, bitmapWidth, bitmapHeight), paint)
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
        canvas?.drawBitmap(bitmapSRC, null, Rect(0, 0, bitmapWidth, bitmapHeight), paint)
        paint.xfermode = null

        canvas?.restoreToCount(layerId)
    }

    private fun generateWavePath() {
        path.reset()
        val originY = bitmapHeight / 2f
        val halfWaveLength = mItemWaveLength / 2
        path.moveTo(-mItemWaveLength + dx, originY)
        var i = -mItemWaveLength
        while (i <= width + mItemWaveLength) {
            path.rQuadTo(halfWaveLength / 2, -50f, halfWaveLength, 0f)
            path.rQuadTo(halfWaveLength / 2, 50f, halfWaveLength, 0f)
            i += mItemWaveLength
        }
        path.lineTo(bitmapWidth.toFloat(), bitmapHeight.toFloat())
        path.lineTo(0f, bitmapHeight.toFloat())
        path.close()
    }

    private fun startAnim() {
        val valueAnimator = ValueAnimator.ofFloat(0f, mItemWaveLength)
        valueAnimator.duration = 2000L
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.addUpdateListener {
            dx = it.animatedValue as Float
            postInvalidate()
        }
        valueAnimator.start()
    }
}