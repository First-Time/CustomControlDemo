package com.lyf.customcontrol.part2.paint07.patheffect.pathdashpath

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import com.lyf.customcontrol.main.generatePaint

class MyPathDashPathView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    View(context, attrs, defStyleAttr) {

    var phase = 0f
    private val valueAnimator: ValueAnimator = ValueAnimator.ofFloat(35f)

    init {
        valueAnimator.repeatMode = ValueAnimator.RESTART
        valueAnimator.repeatCount = ValueAnimator.INFINITE
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.duration = 2000L
        valueAnimator.addUpdateListener { animation ->
            phase = animation.animatedValue as Float
            println("phase = $phase")
            postInvalidate()
        }
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?) : this(context, null)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = generatePaint(Color.GREEN, Paint.Style.STROKE, 5f)

        //画出原始路径
//        val path = getPath()
        val path = Path()
        path.moveTo(100f, 600f)
        path.lineTo(400f, 100f)
        path.lineTo(700f, 900f)

        canvas?.drawPath(path, paint)

        //构建印章路径
        val stampPath = Path()
        stampPath.moveTo(0f, 20f)
        stampPath.lineTo(10f, 0f)
        stampPath.lineTo(20f, 20f)
        stampPath.close()
        stampPath.addCircle(0f, 0f, 3f, Path.Direction.CW)

        //使用印章路径效果
        canvas?.translate(0f, 200f)
        paint.pathEffect =
            PathDashPathEffect(stampPath, 35f, phase, PathDashPathEffect.Style.TRANSLATE)
        canvas?.drawPath(path, paint)

        //使用印章路径效果
        canvas?.translate(0f, 200f)
        paint.pathEffect =
            PathDashPathEffect(stampPath, 35f, phase, PathDashPathEffect.Style.ROTATE)
        canvas?.drawPath(path, paint)

        //使用印章路径效果
        canvas?.translate(0f, 200f)
        paint.pathEffect = PathDashPathEffect(stampPath, 35f, phase, PathDashPathEffect.Style.MORPH)
        canvas?.drawPath(path, paint)
    }

    fun startAnim() {
        valueAnimator.start()
    }

    fun cancelAnim() {
        valueAnimator.cancel()
    }

    fun endAnim() {
        valueAnimator.end()
    }

    fun pauseAnim() {
        valueAnimator.pause()
    }

    fun resumeAnim() {
        valueAnimator.resume()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        println("onDetachedFromWindow")
        valueAnimator.cancel()
    }
}