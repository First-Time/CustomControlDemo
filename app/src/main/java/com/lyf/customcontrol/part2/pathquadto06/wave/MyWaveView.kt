package com.lyf.customcontrol.part2.pathquadto06.wave

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator

class MyWaveView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    val path = Path()
    val paint = Paint()
    private val mItemWaveLength = 1000f
    private var dx = 0f
    private var originY = 300f

    init {
        paint.color = Color.GREEN
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.strokeWidth = 5f
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        path.reset()
        val halfWaveLen = mItemWaveLength / 2

        originY += 2
        if (originY > height + 100) {
            originY = 300f
        }

        path.moveTo(-mItemWaveLength + dx, originY)

        var i = -mItemWaveLength
        while (i < width + mItemWaveLength) {
            path.rQuadTo(halfWaveLen / 2, -100f, halfWaveLen, 0f)
            path.rQuadTo(halfWaveLen / 2, 100f, halfWaveLen, 0f)
            i += mItemWaveLength
        }
        path.lineTo(width.toFloat(), height.toFloat())
        path.lineTo(0f, height.toFloat())
        path.close()

        canvas?.drawPath(path, paint)
    }

    fun startAnim() {
        val valueAnimator = ValueAnimator.ofFloat(0f, mItemWaveLength)
        valueAnimator.duration = 2000
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.addUpdateListener {
            dx = it.animatedValue as Float
            postInvalidate()
        }
        valueAnimator.start()
    }
}